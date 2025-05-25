package com.beppe.kafka.pattern.muban;

import org.testng.annotations.Test;

public class MubanTest {

    @Test
    public void test1(){
//        ProcessTemplate template = new OtherProcessTemplate();
//        template.process();
        Father father = new Father();
        father.doProcess();
    }

}
