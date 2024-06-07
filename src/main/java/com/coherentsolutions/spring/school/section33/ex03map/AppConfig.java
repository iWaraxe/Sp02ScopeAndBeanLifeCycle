package com.coherentsolutions.spring.school.section33.ex03map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.coherentsolutions.spring.school.section33.ex03map",
        "com.coherentsolutions.spring.school.section33.services"
})
public class AppConfig {
    // No need to define beans here if they are already annotated with @Component in the specified packages
}
