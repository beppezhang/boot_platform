package com.beppe.controller;


import com.alibaba.fastjson.JSON;
import com.beppe.entity.City;
import com.beppe.entity.Order;
import com.beppe.model.UserDto;
import com.beppe.pattern.strategy.AbstractCalculateStrategy;
import com.beppe.pattern.strategy.CalculateStrategy;
import com.beppe.pattern.strategy.CalculateStrategyContainer;
import com.beppe.service.UserService;
import com.beppe.utils.JsonUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strategy/")
public class StratetyController {

    @Autowired
    private CalculateStrategyContainer container;

    @Autowired
    private UserService userService;

    @RequestMapping("caculate")
    public void calculate(){
        CalculateStrategy calculateStrategy = container.getCalculateStrategy("globalCalculateStrategy");
        calculateStrategy.calculate("beppe");
    }

    @RequestMapping("cache")
    public void cache(@RequestBody City city){
//        Order user = userService.getUser("11111");
//        int i = user.hashCode();
//        System.out.println("ii:"+i);
        System.out.println("ooo:"+ JSON.toJSONString(city));
        CollectionUtils.isNotEmpty(null);
    }

    @RequestMapping("update")
    public void doUpdate(@RequestBody UserDto userDto){
//        City form = userDto.getForm();
        String jsonString = JsonUtils.toJSONString(userDto);
        City city = JsonUtils.toJavaObject(userDto.getForm(), City.class);
        System.out.println("city:"+jsonString);

    }


}
