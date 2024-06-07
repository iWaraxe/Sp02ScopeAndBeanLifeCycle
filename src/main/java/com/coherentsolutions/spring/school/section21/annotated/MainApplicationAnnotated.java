package com.coherentsolutions.spring.school.section21.annotated;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplicationAnnotated {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigAnnotated.class);

        MyClassAnnotated myBean = context.getBean(MyClassAnnotated.class);
        System.out.println("Bean from context: " + myBean);

        context.close();
    }
}
