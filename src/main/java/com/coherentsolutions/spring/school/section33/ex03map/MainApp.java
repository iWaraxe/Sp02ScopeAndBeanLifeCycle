package com.coherentsolutions.spring.school.section33.ex03map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProcessingManager manager = context.getBean(ProcessingManager.class);

        // Process services by key
        manager.processService("firstService");
        manager.processService("secondService");
        manager.processService("thirdService");
        manager.processService("nonExistingService");

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
