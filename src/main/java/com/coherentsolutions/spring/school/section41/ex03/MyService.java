package com.coherentsolutions.spring.school.section41.ex03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {
    @Autowired
    private MyRepository repository;

    public void performAction() {
        repository.doSomething();
    }
}
