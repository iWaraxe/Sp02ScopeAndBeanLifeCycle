package com.coherentsolutions.spring.school.section41.ex02;

import org.springframework.stereotype.Component;

@Component
public class MyRepository {
    public void doSomething() {
        System.out.println("Repository doing something...");
    }
}