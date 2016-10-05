package com.karuniko.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@EnableScheduling
@Configuration
public class SchedulingConfig implements SchedulingConfigurer {
	
	@Value("${scheduling.threadpool.size:10}")
	private int corePoolSize;
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());

	}
	
	@Bean
	public Executor taskExecutor() {
		return Executors.newScheduledThreadPool(corePoolSize);
	}

}
