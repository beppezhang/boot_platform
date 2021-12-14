package com.beppe.test;


import com.beppe.entity.Order2;
import com.beppe.utils.CartUtil;
import org.testng.annotations.Test;

import java.util.List;

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
        List<Order2> list = CartUtil.buildMultiCartInfo(null, null);

    }



}
