package com.coherentsolutions.spring.school.section35.ex02profiles;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Set the active profile
        System.setProperty("spring.profiles.active", "prod");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigContext.class);
        AppConfig appConfig = context.getBean(AppConfig.class);

        // Print injected properties
        appConfig.printConfig();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
