package com.oqute;

/**
 * Created by karuniko on 09.04.16.
 */
import com.oqute.config.ApplicationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OQuteApplicationBoot extends AbstractAnnotationConfigDispatcherServletInitializer {

    Logger logger = LoggerFactory.getLogger(OQuteApplicationBoot.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ApplicationConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}