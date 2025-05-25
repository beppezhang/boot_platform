package com.beppe.kafka.test;

import org.assertj.core.util.Lists;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo1 {
    
    @Test
    public void test1(){
        List<Integer> list = Lists.newArrayList(1);
        Map<Integer, Object> collect = list.stream().collect(Collectors.toMap(a -> a, a -> 1));
    }
}
