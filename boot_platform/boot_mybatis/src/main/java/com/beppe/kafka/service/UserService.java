package com.beppe.kafka.service;

import com.beppe.kafka.dto.UserDto;
import com.beppe.kafka.mapper.UserMapper;
import com.beppe.kafka.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 保存用户
     * @param
     * @return
     */
    public void saveUser(UserDto userDto) {
        User user = new User();
        org.springframework.beans.BeanUtils.copyProperties(userDto,user);

        userMapper.insert(user);
    }
}
