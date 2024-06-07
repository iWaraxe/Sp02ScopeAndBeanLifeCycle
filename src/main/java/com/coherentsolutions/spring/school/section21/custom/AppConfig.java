package com.coherentsolutions.spring.school.section21.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.coherentsolutions.spring.school.section21.custom")
public class AppConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public MyClass myBean() {
        return new MyClass();
    }
}
