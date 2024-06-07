package com.coherentsolutions.spring.school.section22.ex03messagequeue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageQueueConnectionManager mqManager = context.getBean(MessageQueueConnectionManager.class);

        // Use the connection
        MessageQueueConnectionManager.Connection connection = mqManager.getConnection();
        // Perform message queue operations...

        // Close the context to trigger @PreDestroy
        ((AnnotationConfigApplicationContext) context).close();
    }
}
