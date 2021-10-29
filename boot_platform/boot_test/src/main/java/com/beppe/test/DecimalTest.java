package com.beppe.test;

import org.testng.annotations.Test;

import java.math.BigDecimal;

public class DecimalTest {

    @Test
    public void test1(){
        BigDecimal first = new BigDecimal(25);
        BigDecimal second = new BigDecimal(1000);
        BigDecimal result = first.multiply(second).setScale(2, 4);
        System.out.println("result:"+result);
    }

    @Test
    public void test2(){
        BigDecimal zero = new BigDecimal(0);

    }
}
