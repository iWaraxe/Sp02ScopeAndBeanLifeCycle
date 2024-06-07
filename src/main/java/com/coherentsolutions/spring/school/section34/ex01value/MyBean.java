package com.coherentsolutions.spring.school.section34.ex01value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Value("Hello, World!")
    private String message;

    @Value("42")
    private int number;

    public void printValues() {
        System.out.println("Message: " + message);
        System.out.println("Number: " + number);
    }
}
