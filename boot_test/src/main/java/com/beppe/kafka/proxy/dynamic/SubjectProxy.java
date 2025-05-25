package com.beppe.kafka.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理方法
 */
public class SubjectProxy implements InvocationHandler {

    // 需要真实的目标对象
    private Subject realSubject;

    public SubjectProxy(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前");
        Object res = method.invoke(realSubject, args);
        System.out.println("执行方法后");
        return res;
    }
}
