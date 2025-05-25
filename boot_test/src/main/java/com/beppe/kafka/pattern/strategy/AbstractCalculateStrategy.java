package com.beppe.kafka.pattern.strategy;

public abstract class AbstractCalculateStrategy implements CalculateStrategy {

    protected abstract void doCaculate();

    @Override
    public void calculate(String name) {
        System.out.println("AbstractCalculateStrategy");
        doCaculate();
    }
}
