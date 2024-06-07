package com.coherentsolutions.spring.school.section42;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IService myService = (IService) context.getBean("myServiceThree");

        // Perform action
        myService.performAction();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
