package com.coherentsolutions.spring.school.section42.ex02;

import com.coherentsolutions.spring.school.section42.IService;
import com.coherentsolutions.spring.school.section42.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component ("serviceTwo")
public class MyServiceTwo implements IService {
    private MyClass myBean;

    @Autowired
    @Qualifier("beanTwo")
    public void setMyBean(MyClass myBean) {
        this.myBean = myBean;
    }

    @Override
    public void performAction() {
        myBean.printName();
    }
}
