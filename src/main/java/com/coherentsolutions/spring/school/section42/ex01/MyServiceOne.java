package com.coherentsolutions.spring.school.section42.ex01;

import com.coherentsolutions.spring.school.section42.IService;
import com.coherentsolutions.spring.school.section42.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("serviceOne")
public class MyServiceOne implements IService {

    private final MyClass myBean;

    @Autowired
    public MyServiceOne(@Qualifier("beanOne") MyClass myBean) {
        this.myBean = myBean;
    }

    @Override
    public void performAction() {
        myBean.printName();
    }
}
