package com.oqute.config;

import com.oqute.service.OQuteApplicationService;
import com.oqute.service.OQuteApplicationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.oqute" })
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    OQuteApplicationService oQuteApplicationService() {
        return new OQuteApplicationServiceImpl();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
