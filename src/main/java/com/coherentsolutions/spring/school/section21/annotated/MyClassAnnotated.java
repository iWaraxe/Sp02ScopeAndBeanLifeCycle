package com.coherentsolutions.spring.school.section21.annotated;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyClassAnnotated {

    public MyClassAnnotated() {
        System.out.println("Bean is being created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean is going through init (using @PostConstruct).");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean will destroy now (using @PreDestroy).");
    }
}
