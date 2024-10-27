package com.beppe.kafka.pattern.strategy;

import org.springframework.stereotype.Service;

@Service("globalCalculateStrategy")
public class GlobalCalculateStrategy extends AbstractCalculateStrategy{


    @Override
    protected void doCaculate() {
        System.out.println("GlobalCalculateStrategy");
    }
}
