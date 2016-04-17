package com.oqute.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = { "com.oqute" })
@PropertySource(name = "applicationProperties", value = "classpath:application.properties")
public class TestConfig {

}
