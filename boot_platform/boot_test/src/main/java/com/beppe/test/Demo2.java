package com.beppe.test;

import org.testng.annotations.Test;
import rx.functions.Action0;

public class Demo2 {

    @Test
    public void test1(){
        create(()->
             persist("aaa")
        );
    }

    private void create(Action0 action0){
        System.out.println("this is the create method");

    }

    private void persist(String name){
        System.out.println("this  is the persit:"+name);
    }

    @Test
    public void test3(){

    }


}
