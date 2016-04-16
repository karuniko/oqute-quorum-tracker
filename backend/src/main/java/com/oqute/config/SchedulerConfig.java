package com.oqute.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.oqute.jobs.ScheduledJob;
import com.oqute.jobs.SchedulerTask;
import com.oqute.jobs.SchedulerTaskImpl;

@Configuration
@EnableTransactionManagement
public class SchedulerConfig {
	
	private final static String SCHEDULER_GROUP = "OQUTE_JOB_GROUP";
	
	@Autowired
	@Qualifier("globalAppProperties")
	private Properties globalAppProperties;
	
	@Resource
	ApplicationContext context;
	
	@Value("${quartz.cron.expression}")
	private String cronExpression;
	
	@Value("${hibernate.connection.url}")
	private String jdbcUrl;
	
	@Value("${hibernate.connection.username}")
	private String user;
	
	@Value("${hibernate.connection.password}")
	private String pass;
	
	@Value("${hibernate.driver_class}")
	private String driver;
	
	@Bean
	SchedulerTask schedulerTask() {
		return new SchedulerTaskImpl();
	}
	
	@Bean
	JobDetailFactoryBean jobDetailBean() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(ScheduledJob.class);
		factory.setGroup(SCHEDULER_GROUP);
		factory.setDurability(true);
		Map<String, Object> tasksMap = new HashMap<>();
		tasksMap.put(SchedulerTask.class.getSimpleName(), schedulerTask());
		factory.setJobDataAsMap(tasksMap);
		return factory;
	}
	
	@Bean
	CronTriggerFactoryBean cronTriggerFactory(){
		CronTriggerFactoryBean cron = new CronTriggerFactoryBean();
		cron.setJobDetail(jobDetailBean().getObject());
		cron.setCronExpression(cronExpression);
		return cron;
	}
	
	@Bean(destroyMethod = "close")
	DataSource quartzDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(user);
        dataSource.setPassword(pass);
		return dataSource;
	}
	@Bean
	PlatformTransactionManager quartzTransactionManager() {
		PlatformTransactionManager txManager = new DataSourceTransactionManager(quartzDataSource());
		return txManager;
	}
	
	@Bean
	SchedulerFactoryBean schedulerFactory(CronTriggerFactoryBean cronTriggerFactory) {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setTriggers(cronTriggerFactory.getObject());
		factory.setQuartzProperties(globalAppProperties);
		factory.setTransactionManager(quartzTransactionManager());
		factory.setDataSource(quartzDataSource());
		return factory;
	}

}
