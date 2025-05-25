package com.beppe.kafka.proxy.dynamic;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class Client {

    @Test
    public void test1(){
        Subject subject = new RealSubject();
        SubjectProxy proxy=new SubjectProxy(subject);

        Subject subject1 = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),
                proxy );
        subject1.execute();
    }
}
