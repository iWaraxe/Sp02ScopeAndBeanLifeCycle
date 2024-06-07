package com.coherentsolutions.spring.school.section22.ex03messagequeue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MessageQueueConnectionManager messageQueueConnectionManager() {
        return new MessageQueueConnectionManager();
    }
}
