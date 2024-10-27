package com.beppe.kafka.pattern.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CalculateStrategyContainer implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public CalculateStrategy getCalculateStrategy(String type) {
        CalculateStrategy bean = applicationContext.getBean(type, CalculateStrategy.class);
        return bean;
    }
}
