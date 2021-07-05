package com.beppe.template;

import org.springframework.stereotype.Component;

/**
 * 核心处理流程处理类
 * 继承抽象的父类
 */
@Component("otherProcessTemplate")
public class OtherProcessTemplate extends AbstractProcessTemplate implements ProcessTemplate{

    @Override
    public void process() {
        System.out.println("执行Other模板处理器");

    }

}
