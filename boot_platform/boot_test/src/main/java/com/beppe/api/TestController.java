package com.beppe.api;

import com.beppe.common.ApplicationContextUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("/user")
    @ResponseBody
    public String getUser(){
        String userName = ApplicationContextUtil.getUserName();
        return userName;
    }
}
