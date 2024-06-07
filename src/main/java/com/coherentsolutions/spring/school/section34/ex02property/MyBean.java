package com.coherentsolutions.spring.school.section34.ex02property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Value("${message}")
    private String message;

    @Value("${number}")
    private int number;

    public void printValues() {
        System.out.println("Message: " + message);
        System.out.println("Number: " + number);
    }
}
