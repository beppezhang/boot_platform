package com.beppe.kafka.proxy.dynamic;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProxyService {

    /**
     * 期望注入接口的代理类
     */
    @Resource
    private Subject subject;
    public void doProxyMethod(){
        subject.execute();
    }
}
