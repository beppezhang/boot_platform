package com.beppe.kafka;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * @author beppe
 * @data 2020/12/15 19:00
 * @description : 启动类
 */
@SpringBootApplication
public class RetrofitApplication {

    /**
     * @param args
     * @description:
     * @return: void
     * @author: Mon co
     * @time: 2021/4/27 3:15 下午
     */
    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<>();
        System.out.println(map.get("sss")==null?"null...":"ssss");

//        System.out.println("开始");
//        CommonService commonService = new CommonServiceImpl() {
//            @Override
//            protected void execute() {
//                System.out.println("执行方法");
//            }
//        };
//
//        commonService.print("执行完毕");


//        SpringApplication.run(RetrofitApplication.class, args);
    }
}
