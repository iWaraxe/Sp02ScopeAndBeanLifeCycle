package com.coherentsolutions.spring.school.section22.ex01database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DatabaseConnectionManager databaseConnectionManager() {
        return new DatabaseConnectionManager();
    }
}
