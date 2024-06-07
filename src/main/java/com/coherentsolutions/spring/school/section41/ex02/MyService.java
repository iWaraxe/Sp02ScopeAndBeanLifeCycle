package com.coherentsolutions.spring.school.section41.ex02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {
    private MyRepository repository;

    @Autowired
    public void setRepository(MyRepository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.doSomething();
    }
}