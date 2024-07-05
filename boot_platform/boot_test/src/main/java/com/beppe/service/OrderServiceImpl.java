package com.beppe.service;

import com.beppe.annotation.MediumAnnotion;
import com.beppe.event.PublishEvent;
import com.beppe.model.OrderUpdateInfo;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService, ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @MediumAnnotion
    public void doCal(){
        System.out.println("do the cal");
    }

    public void createorder(){
        // 订单创建成功
        System.out.println("订单-----");
        OrderUpdateInfo orderUpdateInfo = new OrderUpdateInfo();
//        orderUpdateInfo.setOrderId(10001l);
//        orderUpdateInfo.setUpdateType(2);
//        orderUpdateInfo.setOperator("zhang");

        // 发布一个创建成功事件
        applicationEventPublisher.publishEvent(new PublishEvent(this,orderUpdateInfo));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }

}
