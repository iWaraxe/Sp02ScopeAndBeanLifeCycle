package com.coherentsolutions.spring.school.section32;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        // Register a new user
        userService.registerUser("Jane Doe");

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
