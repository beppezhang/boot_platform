package com.beppe.service.impl;

import com.beppe.api.HttpApi;
import com.beppe.bean.User;
import com.beppe.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author beppe
 * @data 2020/12/15 19:45
 * @description :
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private HttpApi httpApi;

    @Override
    public User getUserById(Integer id) {
        User user = httpApi.getUser(id);
        System.out.println(user.toString());
        return user;
    }
}
