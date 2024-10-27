package com.beppe.kafka.service;

import com.beppe.kafka.bean.User;

/**
 * @author beppe
 * @data 2020/12/15 19:44
 * @description :
 */
public interface UserService {

    User getUserById(Integer id);
}
