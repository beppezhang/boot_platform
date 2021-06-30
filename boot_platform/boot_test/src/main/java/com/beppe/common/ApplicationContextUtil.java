package com.beppe.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware{

    @Autowired
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static String getUserName() {
        UserUtil userUtil = applicationContext.getBean(UserUtil.class);
        String name = userUtil.getName();
        System.out.println("获取userNmae:" + name);
        return name;
    }
}
