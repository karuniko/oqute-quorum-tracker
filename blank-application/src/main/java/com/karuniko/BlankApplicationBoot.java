package com.oqute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.karuniko.config.ApplicationConfig;
import com.karuniko.config.WebApplicationConfiguration;

public class BlankApplicationBoot extends AbstractAnnotationConfigDispatcherServletInitializer {

    Logger logger = LoggerFactory.getLogger(BlankApplicationBoot.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebApplicationConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}