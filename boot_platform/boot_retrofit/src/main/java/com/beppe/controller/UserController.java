package com.beppe.controller;

import com.beppe.bean.User;
import com.beppe.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author beppe
 * @data 2020/12/15 19:40
 * @description :
 */

@ResponseBody
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping({"id"})
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

//    @PostMapping("post")
//    public User postUser(@RequestParam(value = "userId") int userId) {
//        User user = new User();
//        user.setId(userId);
//        return user;
//    }
//
//    @GetMapping("get")
//    public User getUser(@RequestParam(value = "userId") int userId) {
//        User user = new User();
//        user.setId(userId);
//        return user;
//    }
}
