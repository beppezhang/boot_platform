package com.beppe.kafka.template;

import org.springframework.stereotype.Component;

/**
 * 外部处理流程处理类
 * 继承抽象的父类
 */
@Component("externalProcessTemplate")
public class ExternalProcessTemplate extends AbstractProcessTemplate implements ProcessTemplate{

    @Override
    public void process() {
        
    }
}
