package com.coherentsolutions.spring.school.section42.ex03;

import com.coherentsolutions.spring.school.section42.MyClass;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component ("beanThree")
public class MyClassThree extends MyClass {
    public MyClassThree() {
        super("Bean Three");
    }
}
