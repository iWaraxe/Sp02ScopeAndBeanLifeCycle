package com.coherentsolutions.spring.school.section34.ex03xml;

public class MyBean {

    private String message;
    private int number;

    // Setters for dependency injection
    public void setMessage(String message) {
        this.message = message;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void printValues() {
        System.out.println("Message: " + message);
        System.out.println("Number: " + number);
    }
}
