package com.beppe.core;

import com.beppe.constant.OrderEvent;
import com.beppe.constant.OrderEventImpl;
import com.beppe.processors.AbstractOrderProcessor;
import com.beppe.processors.OrderProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态机中转站   用于处理状态的流转  事件触发状态更改
 */
@Component
public class OrderStateManager {

    Map<String, OrderProcessor> orderOperatorMaps = new HashMap<>();

    //  orderEvent 封装状态事件
    public void handleEvent(OrderEventImpl orderEvent){
        String eventId = orderEvent.getEventId();
        // 获取到对应的处理器
        OrderProcessor orderProcessor = orderOperatorMaps.get(eventId);
        // 进入处理器处理订单状态流转
        orderProcessor.handle(orderEvent);
    }
}
