package com.beppe.controller;

import com.beppe.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("aspect")
public class MyAspectController {

    @Resource
    private MyService myService;

    @GetMapping("/doHandle")
    public void doHandle() {
        myService.doHandle();
    }
}
