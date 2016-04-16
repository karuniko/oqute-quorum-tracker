package com.oqute.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v1.db.sql.DriverManagerDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.oqute.repository" })
public class PersistenceJPAConfig {

	@Autowired
	@Qualifier("globalAppProperties")
	private Properties globalAppProperties;
	
	@Value("${hibernate.connection.url}")
	private String jdbcUrl;
	
	@Value("${hibernate.connection.username}")
	private String user;
	
	@Value("${hibernate.connection.password}")
	private String pass;

	@Bean
	DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setProperties(globalAppProperties);
		return dataSource;
	}
	
	@Bean(initMethod="migrate")
	Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setDataSource(new DriverManagerDataSource(jdbcUrl, user, pass));
		return flyway;
	}

	@Bean
	@DependsOn("flyway")
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerBean.setDataSource(dataSource);
		entityManagerBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerBean.setPersistenceUnitName("oqute.persistence");
		entityManagerBean.setPackagesToScan("com.oqute.domain");
		entityManagerBean.setJpaProperties(globalAppProperties);
		return entityManagerBean;
	}

	@Bean
	@DependsOn("flyway")
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	@DependsOn("flyway")
	FactoryBean<SessionFactory> sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(globalAppProperties);
		return factoryBean;
	}

}
