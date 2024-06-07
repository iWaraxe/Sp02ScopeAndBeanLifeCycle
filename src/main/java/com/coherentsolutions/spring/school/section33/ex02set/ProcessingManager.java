package com.coherentsolutions.spring.school.section33.ex02set;

import com.coherentsolutions.spring.school.section33.services.ProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProcessingManager {

    private Set<ProcessingService> processingServices;

    @Autowired
    public void setProcessingServices(Set<ProcessingService> processingServices) {
        this.processingServices = processingServices;
    }

    public void processAll() {
        for (ProcessingService service : processingServices) {
            service.process();
        }
    }
}
