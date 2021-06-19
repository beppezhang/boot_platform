package com.beppe.controller;

import com.beppe.statemachine.config.RedisService;
import com.beppe.model.Classes;
import com.beppe.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author beppe
 * @data 2020/7/27 15:35
 * @description :
 */
@Slf4j
@RestController
public class RedisController {

    private static final int TIMEOUT = 5 * 1000;

    @Resource
    private RedisService redisService;

    @PostMapping
    public void testRedis() {
        User user = new User();
        user.setUsername("beppe");
        user.setJob("程序员");
        user.setAge(18);
        Classes classes = new Classes();
        classes.setClassName("语文课");
        List<Classes> classesList = new ArrayList<>();
        classesList.add(classes);
        user.setClasses(classesList);
        redisService.set("user", user);


        User result = (User) redisService.get("user");
        System.out.println(result.toString());

        Map<String, String> map = new HashMap<>();
        map.put("monco", "是个帅哥");
        redisService.set("beppe", map);



        Map<String, String> resultMap = (Map<String, String>) redisService.get("beppe");
        System.out.println(resultMap.values());


        redisService.lSet("lkm", "1");
        redisService.lSet("lkm", "2");

        List list = redisService.lGet("lkm", 0, -1);
        list.forEach(s -> {
            System.out.println(s);
        });

    }
}
