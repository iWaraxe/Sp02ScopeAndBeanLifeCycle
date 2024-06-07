# Appendix 2. What if Spring Framework didn’t support the collection injection?
If Spring did not support injecting collections directly, we would have to manage the collections of beans manually. This approach involves creating and managing the collections within the configuration or the bean itself, resulting in more boilerplate code and less flexibility. Here’s how the code would look for similar tasks without collection injection:

## Example 1: Manually Managing a List

### Step 1: Define the Service Beans

First, we define some service beans, similar to the previous examples.

```java
package com.coherentsolutions.spring.school.section33;

public interface ProcessingService {
    void process();
}

package com.coherentsolutions.spring.school.section33;

import org.springframework.stereotype.Component;

@Component
public class FirstService implements ProcessingService {
    @Override
    public void process() {
        System.out.println("Processing in FirstService");
    }
}

package com.coherentsolutions.spring.school.section33;

import org.springframework.stereotype.Component;

@Component
public class SecondService implements ProcessingService {
    @Override
    public void process() {
        System.out.println("Processing in SecondService");
    }
}

package com.coherentsolutions.spring.school.section33;

import org.springframework.stereotype.Component;

@Component
public class ThirdService implements ProcessingService {
    @Override
    public void process() {
        System.out.println("Processing in ThirdService");
    }
}
```

### Step 2: Create the Bean that Manages the List Manually

Next, we create a bean that manually manages a list of these services.

```java
package com.coherentsolutions.spring.school.section33;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessingManager {

    private ProcessingService firstService;
    private ProcessingService secondService;
    private ProcessingService thirdService;

    @Autowired
    public void setFirstService(FirstService firstService) {
        this.firstService = firstService;
    }

    @Autowired
    public void setSecondService(SecondService secondService) {
        this.secondService = secondService;
    }

    @Autowired
    public void setThirdService(ThirdService thirdService) {
        this.thirdService = thirdService;
    }

    public void processAll() {
        firstService.process();
        secondService.process();
        thirdService.process();
    }
}
```

In this example, the `ProcessingManager` class has individual setter methods for each service. The `processAll` method calls the `process` method on each service manually.

### Step 3: Configure and Run the Application

We use the same configuration and main application class as before but without the collection injection.

#### Java-based Configuration

```java
package com.coherentsolutions.spring.school.section33;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.coherentsolutions.spring.school.section33")
public class AppConfig {
}
```

#### Main Application Class

```java
package com.coherentsolutions.spring.school.section33;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProcessingManager manager = context.getBean(ProcessingManager.class);

        // Process all services
        manager.processAll();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
```

## Example 2: Manually Managing a Map

If we need to manage a collection of services accessible by keys, we would manually manage the map within the bean.

### Step 1: Define the Service Beans

We use the same service beans as before.

### Step 2: Create the Bean that Manages the Map Manually

Next, we create a bean that manually manages a map of these services.

```java
package com.coherentsolutions.spring.school.section33;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProcessingManager {

    private final Map<String, ProcessingService> processingServices = new HashMap<>();

    @Autowired
    public void setFirstService(FirstService firstService) {
        processingServices.put("firstService", firstService);
    }

    @Autowired
    public void setSecondService(SecondService secondService) {
        processingServices.put("secondService", secondService);
    }

    @Autowired
    public void setThirdService(ThirdService thirdService) {
        processingServices.put("thirdService", thirdService);
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
```

In this example, the `ProcessingManager` class manually adds each service to a map. The `processService` method takes a key and calls the `process` method on the corresponding service.

### Step 3: Configure and Run the Application

We use the same configuration and main application class as before but without the collection injection.

#### Java-based Configuration

```java
package com.coherentsolutions.spring.school.section33;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.coherentsolutions.spring.school.section33")
public class AppConfig {
}
```

#### Main Application Class

```java
package com.coherentsolutions.spring.school.section33;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProcessingManager manager = context.getBean(ProcessingManager.class);

        // Process services by key
        manager.processService("firstService");
        manager.processService("secondService");
        manager.processService("thirdService");
        manager.processService("nonExistingService");

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
```

## Summary

Without the ability to inject collections directly, we would need to manage each dependency individually within the configuration or the bean itself. This approach involves more boilerplate code and is less flexible compared to using collection injection. By manually managing collections, we lose some of the benefits of Spring's dependency injection capabilities, making the code less modular and harder to maintain.