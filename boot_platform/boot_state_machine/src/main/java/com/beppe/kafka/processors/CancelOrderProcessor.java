package com.beppe.kafka.processors;


import com.beppe.kafka.annotation.OrderProcess;
import com.beppe.kafka.constant.OrderEvent;
import com.beppe.kafka.constant.OrderEventImpl;
import com.beppe.kafka.constant.OrderStatusEnum;
import org.springframework.stereotype.Component;

@Component
@OrderProcess(event = OrderEvent.EVT_CANCEL_ORDER)
public class CancelOrderProcessor extends AbstractOrderProcessor{

    @Override
    public  void doProcess(OrderEventImpl orderEvent){
        System.out.println("进入取消订单逻辑CancelOrderProcessor");

    }

    @Override
    protected int getTargetStatus() {
        return OrderStatusEnum.ORDER_CANCEL.status;
    }
}
