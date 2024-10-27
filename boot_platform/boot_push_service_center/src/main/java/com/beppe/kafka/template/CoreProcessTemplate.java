package com.beppe.kafka.template;

import org.springframework.stereotype.Component;

/**
 * 核心处理流程处理类
 * 继承抽象的父类
 */
@Component("coreProcessTemplate")
public class CoreProcessTemplate extends AbstractProcessTemplate implements ProcessTemplate{

    @Override
    public void process() {

    }
}
