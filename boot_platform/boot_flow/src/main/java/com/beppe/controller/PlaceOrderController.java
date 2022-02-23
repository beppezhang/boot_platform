package com.beppe.controller;

import com.beppe.myorder.PlaceOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myExtention/")
public class PlaceOrderController {

    @Autowired
    private PlaceOrder placeOrder;

    @RequestMapping("placeOrder")
    public String placeOrder() {

        return placeOrder.place();
    }
}
