package com.coherentsolutions.spring.school.section33.ex03map;

import com.coherentsolutions.spring.school.section33.services.ProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProcessingManager {

    private Map<String, ProcessingService> processingServices;

    @Autowired
    public void setProcessingServices(Map<String, ProcessingService> processingServices) {
        this.processingServices = processingServices;
    }

    public void processService(String key) {
        ProcessingService service = processingServices.get(key);
        if (service != null) {
            service.process();
        } else {
            System.out.println("No service found for key: " + key);
        }
    }
}
