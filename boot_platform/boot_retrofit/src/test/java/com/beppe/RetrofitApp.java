package com.beppe;

import com.beppe.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author beppe
 * @data 2020/12/15 19:36
 * @description :
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RetrofitApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RetrofitApp {

    @Resource
    private UserService userService;

    @Test
    public void test() {
        userService.getUserById(1);
    }
}
