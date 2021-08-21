package com.beppe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
@RefreshScope
public class SampleController {

    @Value("${userName}")
    String userName;

    @RequestMapping("/acm")
    public String simple() {
        return "Hello Spring Cloud ACM!" + "Hello " + userName + "!";
    }
}
