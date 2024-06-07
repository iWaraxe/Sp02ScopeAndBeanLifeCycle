# Appendix 1. Description of the Spring Boot Application to Demonstrate Request and Session Scopes

This Spring Boot application demonstrates the difference between Request and Session scopes using Spring beans. The application consists of a simple configuration, a controller, and a model class to showcase the behavior of beans with different scopes.

### Project Structure

1. **Configuration Class**: Defines the scoped beans.
2. **Controller Class**: Handles HTTP requests and binds the beans to the view.
3. **Model Class**: Represents the beans with unique IDs.
4. **Main Application Class**: Bootstraps the Spring Boot application.
5. **View Template**: Displays the bean details.

### Detailed Description

#### 1. Configuration Class

The `AppConfig` class defines two beans with different scopes: request and session.

```java
package com.coherentsolutions.spring.school.springbootbeanscopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class AppConfig {

    @Bean(name = "requestBean")
    @RequestScope
    public MyClass requestBean() {
        return new MyClass("Request Bean");
    }

    @Bean(name = "sessionBean")
    @SessionScope
    public MyClass sessionBean() {
        return new MyClass("Session Bean");
    }
}
```

#### 2. Controller Class

The `MainController` handles incoming HTTP GET requests to the root URL (`/`) and binds the request and session scoped beans to the model, which is then used in the view.

```java
package com.coherentsolutions.spring.school.springbootbeanscopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    @Qualifier("requestBean")
    private MyClass requestBean;

    @Autowired
    @Qualifier("sessionBean")
    private MyClass sessionBean;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("requestBean", requestBean);
        model.addAttribute("sessionBean", sessionBean);
        return "home";
    }
}
```

#### 3. Model Class

The `MyClass` is a simple POJO with a static `AtomicInteger` to generate unique IDs for each instance, which helps in identifying the instances across different scopes.

```java
package com.coherentsolutions.spring.school.springbootbeanscopes;

import java.util.concurrent.atomic.AtomicInteger;

public class MyClass {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String name;

    public MyClass(String name) {
        this.id = count.incrementAndGet();
        this.name = name;
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
```

#### 4. Main Application Class

The `SpringBootBeanScopesApplication` class is the entry point of the Spring Boot application.

```java
package com.coherentsolutions.spring.school.springbootbeanscopes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBeanScopesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBeanScopesApplication.class, args);
    }
}
```

#### 5. View Template

The Thymeleaf template `home.html` displays the names and IDs of the request and session scoped beans.

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Bean Scopes</title>
</head>
<body>
<h1>Spring Bean Scopes Example</h1>
<p>Request Bean: <span th:text="${requestBean.name} + ' (ID: ' + ${requestBean.id} + ')'"></span></p>
<p>Session Bean: <span th:text="${sessionBean.name} + ' (ID: ' + ${sessionBean.id} + ')'"></span></p>
</body>
</html>
```

### Running the Application

1. **Start the Application**: Run the `SpringBootBeanScopesApplication` main class.
2. **Access the Application**: Open a browser and navigate to `http://localhost:8080/`.

### Observing Bean Scopes

- **Request Scope**: The ID of the `requestBean` changes with each page reload, indicating a new instance is created for each request.
- **Session Scope**: The ID of the `sessionBean` remains the same across page reloads within the same session, indicating the same instance is used. To see a different ID, start a new session by using an incognito window or a different browser.

This setup demonstrates the difference between request and session scoped beans in a Spring Boot application.