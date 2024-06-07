// File: com/coherentsolutions/spring/school/section11/MyClass.java
package com.coherentsolutions.spring.school.section11;

public class MyClass {

    private final String name;

    public MyClass(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("Bean Name: " + name);
    }
}
