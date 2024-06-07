package com.coherentsolutions.spring.school.section21.custom;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyClass myBean = context.getBean(MyClass.class);
        System.out.println("Bean from context: " + myBean);

        context.close();
    }
}
