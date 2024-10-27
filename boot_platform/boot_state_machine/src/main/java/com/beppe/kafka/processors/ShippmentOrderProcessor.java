package com.beppe.kafka.processors;

import com.beppe.kafka.annotation.OrderProcess;
import com.beppe.kafka.constant.OrderEvent;
import com.beppe.kafka.constant.OrderEventImpl;
import com.beppe.kafka.constant.OrderStatusEnum;
import org.springframework.stereotype.Component;

@Component
@OrderProcess(event = OrderEvent.EVT_SHIPPEMNT_ORDER)
public class ShippmentOrderProcessor extends AbstractOrderProcessor{

    @Override
    public  void doProcess(OrderEventImpl orderEvent){
        System.out.println("进入订单发货事件的执行ShippmentOrderProcessor");
    }

    @Override
    protected int getTargetStatus() {
        return OrderStatusEnum.ORDER_SHIPMENT_OK.status;
    }
}
