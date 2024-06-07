package com.coherentsolutions.spring.school.section22.ex01database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DatabaseConnectionManager dbManager = context.getBean(DatabaseConnectionManager.class);

        // Use the connection
        Connection connection = dbManager.getConnection();
        // Perform database operations...

        // Close the context to trigger @PreDestroy
        ((AnnotationConfigApplicationContext) context).close();
    }
}
