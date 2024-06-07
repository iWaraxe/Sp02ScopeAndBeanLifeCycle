package com.coherentsolutions.spring.school.section35.ex02profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.coherentsolutions.spring.school.section35.ex02profiles")
public class AppConfigContext {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Configuration
    @Profile("dev")
    @PropertySource("classpath:application-dev.properties")
    static class DevConfig {
    }

    @Configuration
    @Profile("prod")
    @PropertySource("classpath:application-prod.properties")
    static class ProdConfig {
    }
}
