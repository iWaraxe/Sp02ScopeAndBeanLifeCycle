package com.coherentsolutions.spring.school.section34.ex02property;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.coherentsolutions.spring.school.section34.ex02property")
@PropertySource("classpath:application.properties")
public class AppConfig {
}
