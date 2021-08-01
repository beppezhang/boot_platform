package com.beppe.api;

import com.beppe.common.ApplicationContextUtil;
import com.beppe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public String getUser(){
//        String userName = ApplicationContextUtil.getUserName();
        userService.create();
        return "test";
    }
}
