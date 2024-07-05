package com.beppe.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListner implements ApplicationListener<PublishEvent> {

    @Override
    public void onApplicationEvent(PublishEvent publishEvent) {
        // 监听到信息开始执行
        System.out.println("监听到数据,publishEvent:"+publishEvent.getOrderUpdateInfo().getOperator());
    }

}
