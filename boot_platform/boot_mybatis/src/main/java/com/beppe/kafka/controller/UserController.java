package com.beppe.kafka.controller;

import com.beppe.kafka.dto.UserDto;
import com.beppe.kafka.mapper.UserMapper;
import com.beppe.kafka.model.User;
import com.beppe.kafka.model.UserQuery;
import com.beppe.kafka.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

/**
 * @author beppe
 * @data 2020/9/2 15:50
 * @description :
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("{id}")
    @ResponseBody
    public User selectUserById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PostMapping("save")
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

//    @GetMapping("list")
//    public PageInfo<User> selectUserList(UserQuery userQuery) {
////        List<String> idList = new ArrayList<>();
////        idList.add("1");
////        List<String> realNameList = new ArrayList<>();
////        realNameList.add("beppe");
////        userQuery.setIdList(idList);
////        userQuery.setRealNameList(realNameList);
//        PageHelper.startPage(1, 5);
//        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectUserList(userQuery));
//        return pageInfo;
//    }
//
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