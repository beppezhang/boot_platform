package com.beppe.kafka.proxy.statictype;

import org.testng.annotations.Test;

/**
 * 拆单客户端   调用拆单方法进行拆单
 */
public class SplitClient {


    @Test
    public void test1(){
        //执行拆单的入口方法
        SplitStrategy proxy = new ProxySplitStrategy();
        proxy.split();
    }
}
