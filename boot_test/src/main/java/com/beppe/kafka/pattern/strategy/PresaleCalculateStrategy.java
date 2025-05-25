package com.beppe.kafka.pattern.strategy;

import org.springframework.stereotype.Service;

@Service("presaleCalculateStrategy")
public class PresaleCalculateStrategy extends AbstractCalculateStrategy {

    @Override
    protected void doCaculate() {
        System.out.println("PresaleCalculateStrategy");
    }
}
