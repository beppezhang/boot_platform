package com.beppe.kafka.controller;

import com.beppe.kafka.cache.CaffeineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cache/")
public class CacheController {

    @Resource
    private CaffeineService caffeineService;

    @RequestMapping("getUser")
    public String getUser(Long id){
        String user = caffeineService.getUser(id);
        return user;
    }

    @RequestMapping("getCity")
    public String getCity(String name){
        String city = caffeineService.getCity(name);
        return city;
    }

    @RequestMapping("getPerson")
    public String getPerson(String personName){
        String name = caffeineService.getPerson(personName);
        return name;
    }
}
