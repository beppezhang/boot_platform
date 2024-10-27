package com.beppe.kafka.proxy.dynamic;

public class RealSubject implements Subject{


    @Override
    public void execute() {
        System.out.println("执行真实目标方法");
    }
}
