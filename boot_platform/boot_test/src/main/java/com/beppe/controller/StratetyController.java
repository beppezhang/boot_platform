package com.beppe.controller;


import com.beppe.pattern.strategy.AbstractCalculateStrategy;
import com.beppe.pattern.strategy.CalculateStrategy;
import com.beppe.pattern.strategy.CalculateStrategyContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strategy/")
public class StratetyController {

    @Autowired
    private CalculateStrategyContainer container;

    @RequestMapping("caculate")
    public void calculate(){
        CalculateStrategy calculateStrategy = container.getCalculateStrategy("globalCalculateStrategy");
        calculateStrategy.calculate("beppe");
    }
}
