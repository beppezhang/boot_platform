package com.beppe.register;

import com.beppe.annotation.Register;
import com.beppe.common.StrategyProcessor;
import com.beppe.container.GlobalContainer;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * 将 @Register  注解的类注册进来
 * 项目启动的时候将其注册进来
 */
@Component
public class BusinessRegister implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @PostConstruct
    public void register() {
        // 获取所有的@Register 注解
        Map<String, Object> registerBeans = applicationContext.getBeansWithAnnotation(Register.class);
        registerBeans.values().forEach(register -> doRegister((StrategyProcessor) register));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void doRegister(StrategyProcessor pro) {
        // code + topic 作为key
        Register registerAnn = pro.getClass().getDeclaredAnnotation(Register.class);
        String key = registerAnn.code() + registerAnn.topic();
        List<String> strategies = pro.getStrategies();
        GlobalContainer.instance.put(key, strategies);
        System.out.println("获取到的策略" + strategies);
    }
}
