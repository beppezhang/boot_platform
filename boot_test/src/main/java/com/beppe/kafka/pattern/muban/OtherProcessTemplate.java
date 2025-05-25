package com.beppe.kafka.pattern.muban;

public class OtherProcessTemplate extends AbstractTemplate{

    @Override
    protected void doProcess() {
        System.out.println("this is the OtherProcessTemplate doProcess");
    }

//    @Override
//    public void process() {
//        System.out.println("this is the OtherProcessTemplate process");
//    }
}
