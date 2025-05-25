package com.beppe.kafka.proxy.dynamic;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class ExtensionProxyFactoryBean<T> implements FactoryBean<T> {

    // 这里返回动态代理类交给spring 管理
    private Class<T> proxyType;
    @Override
    public T getObject() throws Exception {
        // 创建代理类返回
//        Subject subject1 = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),
//                proxy );
        Subject subject = new RealSubject();
        SubjectProxy proxy = new SubjectProxy(subject);
        // todo 改造成返回动态代理对象
        return  (T) Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),
                proxy );
    }

    @Override
    public Class<?> getObjectType() {
        return Subject.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
