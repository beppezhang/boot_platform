package com.beppe.kafka.commontest;

import org.assertj.core.util.Lists;
import org.testng.annotations.Test;

import java.util.List;

public class Demo1 {
    
    @Test
    public void test1(){
        List<String> list = Lists.newArrayList("11", "22", "33", "44", "55");
        List<List<String>> partition = com.google.common.collect.Lists.partition(list, 3);
    }
}
