package com.coherentsolutions.spring.school.section41.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = context.getBean(MyService.class);

        // Perform action
        myService.performAction();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}