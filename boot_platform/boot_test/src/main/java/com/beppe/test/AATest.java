package com.beppe.test;

import org.testng.annotations.Test;

public class AATest {

    @Test
    public void test1(){
        System.out.println(2|4);
        int i = 6;
        int i1 = i & 1024;
        System.out.println("il:"+i1);
    }
//
//
    @Test
    public void test2(){
        // 与运算I
        Integer i=null;
        Integer i1 = i==null ? null:i&2;
        System.out.println("flag:"+i1);
    }
}
