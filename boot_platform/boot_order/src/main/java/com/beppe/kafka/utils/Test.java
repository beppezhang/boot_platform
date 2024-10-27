package com.beppe.kafka.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mon co
 * @description
 * @time 2021/5/8 3:32 下午
 */
@Component
public class Test {

    @Autowired
    public Test(List<TestService> testServiceList) {
        System.out.println("size:" + testServiceList.size());
    }
}
