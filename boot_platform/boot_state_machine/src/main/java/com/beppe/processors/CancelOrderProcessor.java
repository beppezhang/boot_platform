package com.beppe.processors;


import com.beppe.annotation.OrderProcess;
import com.beppe.constant.OrderEvent;
import com.beppe.constant.OrderEventImpl;
import com.beppe.constant.OrderStatusEnum;

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
