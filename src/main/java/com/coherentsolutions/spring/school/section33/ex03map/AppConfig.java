package com.coherentsolutions.spring.school.section33.ex03map;

import com.coherentsolutions.spring.school.section33.services.FirstService;
import com.coherentsolutions.spring.school.section33.services.SecondService;
import com.coherentsolutions.spring.school.section33.services.ThirdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.coherentsolutions.spring.school.section33.ex03map")
public class AppConfig {
    @Bean
    public FirstService firstService() {
        return new FirstService();
    }

    @Bean
    public SecondService secondService() {
        return new SecondService();
    }

    @Bean
    public ThirdService thirdService() {
        return new ThirdService();
    }
}
