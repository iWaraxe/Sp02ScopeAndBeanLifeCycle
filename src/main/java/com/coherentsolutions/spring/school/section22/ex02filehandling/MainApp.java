package com.coherentsolutions.spring.school.section22.ex02filehandling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FileHandler fileHandler = context.getBean(FileHandler.class);

        // Write data to the file
        fileHandler.writeData("Hello, World!");
        fileHandler.writeData("Another line of text.");

        // Close the context to trigger @PreDestroy
        ((AnnotationConfigApplicationContext) context).close();
    }
}
