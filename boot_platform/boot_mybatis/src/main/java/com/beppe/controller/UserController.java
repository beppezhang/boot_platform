package com.beppe.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.beppe.model.User;
import com.beppe.model.UserQuery;
import com.beppe.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author beppe
 * @data 2020/9/2 15:50
 * @description :
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("{id}")
    public User selectUserById(@PathVariable("id") Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @GetMapping("list")
    public PageInfo<User> selectUserList(UserQuery userQuery) {
//        List<String> idList = new ArrayList<>();
//        idList.add("1");
//        List<String> realNameList = new ArrayList<>();
//        realNameList.add("beppe");
//        userQuery.setIdList(idList);
//        userQuery.setRealNameList(realNameList);
        PageHelper.startPage(1, 5);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectUserList(userQuery));
        return pageInfo;
    }

    @PostMapping("post")
    public User postUser(@RequestParam(value = "userId") int userId) {
        User user = new User();
        user.setId(userId);
        return user;
    }

    @GetMapping("get")
    public User getUser(@RequestParam(value = "userId") int userId) {
        User user = new User();
        user.setId(userId);
        return user;
    }
}