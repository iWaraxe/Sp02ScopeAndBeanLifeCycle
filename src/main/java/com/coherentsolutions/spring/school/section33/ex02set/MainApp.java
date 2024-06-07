package com.coherentsolutions.spring.school.section33.ex02set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProcessingManager manager = context.getBean(ProcessingManager.class);

        // Process all services
        manager.processAll();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
