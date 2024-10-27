package com.beppe.kafka.pattern.muban;

public abstract class AbstractTemplate implements ProcessTemplate{

    @Override
    public void process() {
        System.out.println("这是AbstractTemplate 执行的process");
        doProcess();
    }

    protected abstract void doProcess();
}
