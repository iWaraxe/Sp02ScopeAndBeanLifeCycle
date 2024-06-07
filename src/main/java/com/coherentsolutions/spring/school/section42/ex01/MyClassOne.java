package com.coherentsolutions.spring.school.section42.ex01;

import com.coherentsolutions.spring.school.section42.MyClass;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("beanOne")
public class MyClassOne extends MyClass {
    public MyClassOne() {
        super("Bean One");
    }
}
