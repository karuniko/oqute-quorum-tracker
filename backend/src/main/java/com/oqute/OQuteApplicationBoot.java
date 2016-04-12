package com.oqute;

/**
 * Created by karuniko on 09.04.16.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class OQuteApplicationBoot extends SpringBootServletInitializer {

    private static Class<OQuteApplicationBoot> applicationClass = OQuteApplicationBoot.class;

    public static void main(String[] args) {
        SpringApplication.run(OQuteApplicationBoot.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}