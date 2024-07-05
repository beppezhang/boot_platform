package com.beppe.test;

import com.beppe.annotation.MediumAnnotion;
import com.beppe.service.OrderServiceImpl;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AnnotationTest {

    @Test
    public void test(){
        // 获取使用MediumAnnotion  的方法
        Class<OrderServiceImpl> orderServiceClass = OrderServiceImpl.class;
        Method[] methods = orderServiceClass.getMethods();
        for(Method m:methods){
            MediumAnnotion annotation = m.getAnnotation(MediumAnnotion.class);
            if(annotation!=null){
                System.out.println("aaa:"+annotation.code());
            }
        }
    }
}
