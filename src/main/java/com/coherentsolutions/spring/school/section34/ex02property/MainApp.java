package com.coherentsolutions.spring.school.section34.ex02property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean myBean = context.getBean(MyBean.class);

        // Print injected values
        myBean.printValues();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
