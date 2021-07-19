package com.beppe.core;

import com.beppe.annotation.OrderProcess;
import com.beppe.processors.OrderProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class Initialization implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private OrderStateManager orderStateManager;


    // 容器启动  注册事件处理器
    @PostConstruct
    public void init() throws BeansException {
        //todo  获取所有OrderProcess  并且注册
        Map<String, Object> processors = applicationContext.getBeansWithAnnotation(OrderProcess.class);
        //  注册
        processors.values().forEach(p->register((OrderProcessor)p));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void register(OrderProcessor processor){
        OrderProcess annotation = processor.getClass().getAnnotation(OrderProcess.class);
        orderStateManager.orderOperatorMaps.put(annotation.event(),processor);
    }
}
