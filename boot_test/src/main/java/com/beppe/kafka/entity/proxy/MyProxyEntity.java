package com.beppe.kafka.entity.proxy;

public class MyProxyEntity implements ProxyEntityInterface{

    private String name;

    private String code;


    @Override
    public void doInvoke() {
        System.out.println("this is the proxy");
    }
}
