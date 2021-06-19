package com.beppe.controller;

import com.beppe.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    ThreadPoolExecutor pool = new ThreadPoolExecutor(100, 199, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    @Autowired
    private IUserService userService;

    @RequestMapping("user")
    @ResponseBody
    public String makeOrder() {
        // 摸你1000qps的并发
        for (int i = 0; i < 100; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程执行中："+Thread.currentThread().getName());
                        userService.buyGoods();
                    } catch (InterruptedException e) {
                        System.out.println("创建订单失败,e："+e.getMessage());
                        e.printStackTrace();
                    }
                }
            });
        }

        return "ORDER";
    }
}
