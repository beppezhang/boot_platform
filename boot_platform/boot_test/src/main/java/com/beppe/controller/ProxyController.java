package com.beppe.controller;

import com.beppe.proxy.dynamic.ProxyService;
import com.beppe.proxy.dynamic.Subject;
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
