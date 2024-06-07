package com.coherentsolutions.spring.school.section33.services;

import org.springframework.stereotype.Component;

@Component
public class FirstService implements ProcessingService {
    @Override
    public void process() {
        System.out.println("Processing in FirstService");
    }
}
