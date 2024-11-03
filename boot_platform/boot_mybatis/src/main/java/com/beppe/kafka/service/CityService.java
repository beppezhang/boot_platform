package com.beppe.kafka.service;

import org.springframework.stereotype.Service;

@Service
public class CityService {

    public String getCityName(){
        System.out.println("this is shanghai ");
        return "shanghai";
    }
}
