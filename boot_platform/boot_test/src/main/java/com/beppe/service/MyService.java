package com.beppe.service;

import com.beppe.annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @LogExecutionTime
    public void doHandle(){
        System.out.println("this is doing my job");
    }
}
