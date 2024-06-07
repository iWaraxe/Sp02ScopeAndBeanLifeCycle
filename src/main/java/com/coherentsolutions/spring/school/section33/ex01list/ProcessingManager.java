package com.coherentsolutions.spring.school.section33.ex01list;

import com.coherentsolutions.spring.school.section33.services.ProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessingManager {

    private List<ProcessingService> processingServices;

    @Autowired
    public void setProcessingServices(List<ProcessingService> processingServices) {
        this.processingServices = processingServices;
    }

    public void processAll() {
        for (ProcessingService service : processingServices) {
            service.process();
        }
    }
}
