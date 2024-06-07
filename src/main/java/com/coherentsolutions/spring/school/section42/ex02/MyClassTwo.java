package com.coherentsolutions.spring.school.section42.ex02;

import com.coherentsolutions.spring.school.section42.MyClass;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("beanTwo")
public class MyClassTwo extends MyClass {
    public MyClassTwo() {
        super("Bean Two");
    }
}
