package com.coherentsolutions.spring.school.section42.ex03;

import com.coherentsolutions.spring.school.section42.IService;
import com.coherentsolutions.spring.school.section42.MyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component ("myServiceThree")
public class MyServiceThree implements IService {
    @Autowired
    @Qualifier("beanThree")
    private MyClass myBean;

    @Override
    public void performAction() {
        myBean.printName();
    }
}
