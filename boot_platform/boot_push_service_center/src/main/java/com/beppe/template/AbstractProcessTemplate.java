package com.beppe.template;

public abstract class AbstractProcessTemplate {

    public void doProcess(){
        System.out.println("开始执行父类模板");
        //  todo 自定义模板方法的实现   各自模板走相应的策略
        System.out.println("执行父类模板结束");
    }
}
