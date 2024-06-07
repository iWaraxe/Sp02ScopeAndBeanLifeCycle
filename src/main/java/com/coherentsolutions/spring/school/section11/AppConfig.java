package com.coherentsolutions.spring.school.section11;
// File: com/coherentsolutions/spring/school/section11/AppConfig.java

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;


@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton")
    public MyClass singletonBean() {
        return new MyClass("Singleton Bean");
    }

    @Bean
    @Scope("prototype")
    public MyClass prototypeBean() {
        return new MyClass("Prototype Bean");
    }

    @Bean
    @RequestScope
    //@Scope("request")
    public MyClass requestBean() {
        return new MyClass("Request Bean");
    }

    @Bean
    @SessionScope
    //@Scope("session")
    public MyClass sessionBean() {
        return new MyClass("Session Bean");
    }

    @Bean
    @Scope("globalSession")
    public MyClass globalSessionBean() {
        return new MyClass("Global Session Bean");
    }
}
