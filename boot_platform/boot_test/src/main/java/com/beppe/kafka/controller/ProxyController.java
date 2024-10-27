package com.beppe.kafka.controller;

import com.beppe.kafka.proxy.dynamic.ProxyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/proxy/")
public class ProxyController {

    @Resource
    private ProxyService proxyService;

    @RequestMapping("factoryBean")
    public String doFactoryBean(){
        proxyService.doProxyMethod();
        return "factoryBean successful";
    }


}
