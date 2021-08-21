package com.beppe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
class SampleRunner implements ApplicationRunner {

//    @Value("${user.id}")
//    String userId;

    @Value("${userName}")
    String userName;

//    @Value("${user.age}")
//    int userAge;

    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(userId);
        System.out.println(userName);
//        System.out.println(userAge);
    }
}

