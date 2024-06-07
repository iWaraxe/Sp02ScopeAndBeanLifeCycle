// File: com/coherentsolutions/spring/school/section11/Main.java
package com.coherentsolutions.spring.school.section11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MyClass singleton1 = context.getBean("singletonBean", MyClass.class);
        MyClass singleton2 = context.getBean("singletonBean", MyClass.class);
        System.out.println("Singleton Bean:");
        singleton1.printName();
        singleton2.printName();
        System.out.println("Same instance? " + (singleton1 == singleton2));

        MyClass prototype1 = context.getBean("prototypeBean", MyClass.class);
        MyClass prototype2 = context.getBean("prototypeBean", MyClass.class);
        System.out.println("Prototype Bean:");
        prototype1.printName();
        prototype2.printName();
        System.out.println("Same instance? " + (prototype1 == prototype2));

        // For RequestScope, SessionScope, and GlobalSessionScope beans, use a Spring web application context
        // Below examples only work in a Spring web application
        // Uncomment and run in a web environment
        /*
        MyClass request1 = context.getBean("requestBean", MyClass.class);
        MyClass request2 = context.getBean("requestBean", MyClass.class);
        System.out.println("Request Bean:");
        request1.printName();
        request2.printName();
        System.out.println("Same instance? " + (request1 == request2));

        MyClass session1 = context.getBean("sessionBean", MyClass.class);
        MyClass session2 = context.getBean("sessionBean", MyClass.class);
        System.out.println("Session Bean:");
        session1.printName();
        session2.printName();
        System.out.println("Same instance? " + (session1 == session2));

        MyClass globalSession1 = context.getBean("globalSessionBean", MyClass.class);
        MyClass globalSession2 = context.getBean("globalSessionBean", MyClass.class);
        System.out.println("Global Session Bean:");
        globalSession1.printName();
        globalSession2.printName();
        System.out.println("Same instance? " + (globalSession1 == globalSession2));
        */

        ((AnnotationConfigApplicationContext) context).close();
    }
}
