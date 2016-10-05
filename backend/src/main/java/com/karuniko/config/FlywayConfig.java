package com.karuniko.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class FlywayConfig {
	@Value("${hibernate.connection.url}")
	private String jdbcUrl;
	
	@Value("${hibernate.connection.username}")
	private String user;
	
	@Value("${hibernate.connection.password}")
	private String pass;
	
	@Value("${hibernate.driver_class}")
	private String driver;
	
	@Bean
	DataSource flywayDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(user);
        dataSource.setPassword(pass);
		return dataSource;
	}
	
	@Bean(initMethod="migrate")
	Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setDataSource(flywayDataSource());
		return flyway;
	}
}
