package com.coherentsolutions.spring.school.section22.ex02filehandling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FileHandler fileHandler() {
        return new FileHandler();
    }
}
