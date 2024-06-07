package com.coherentsolutions.spring.school.section34.ex03xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext35.xml");
        MyBean myBean = context.getBean(MyBean.class);

        // Print injected values
        myBean.printValues();

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
