package com.coherentsolutions.spring.school.section33.services;

import org.springframework.stereotype.Component;

@Component
public class SecondService implements ProcessingService {
    @Override
    public void process() {
        System.out.println("Processing in SecondService");
    }
}
