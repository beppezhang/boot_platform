package com.beppe.controller;

import com.beppe.bean.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mon co
 * @description
 * @time 2021/5/17 2:33 下午
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("getUser")
    public User getUser(@RequestParam(value = "id") Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @PostMapping("postUser")
    public User postUser(@RequestParam(value = "id") Integer id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
