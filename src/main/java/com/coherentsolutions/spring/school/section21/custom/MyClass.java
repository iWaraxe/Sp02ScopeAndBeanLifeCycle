package com.coherentsolutions.spring.school.section21.custom;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.atomic.AtomicInteger;

public class MyClass {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String name;

    public MyClass() {
        this.id = count.incrementAndGet();
        this.name = "MyClass Bean";
        System.out.println("Bean is being created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean is going through init (using @PostConstruct).");
    }

    public void customInit() {
        System.out.println("Bean is going through customInit.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean will destroy now (using @PreDestroy).");
    }

    public void customDestroy() {
        System.out.println("Bean will destroy now via customDestroy.");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
