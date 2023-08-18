package com.beppe.processors;

import com.beppe.annotation.OrderProcess;
import com.beppe.constant.OrderEvent;
import com.beppe.constant.OrderEventImpl;
import com.beppe.constant.OrderStatusEnum;
import com.beppe.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@OrderProcess(event = OrderEvent.EVT_CREATE_ORDER)
public class CreateOrderProcessor extends AbstractOrderProcessor{


    @Override
    public  void doProcess(OrderEventImpl orderEvent){
        //

        System.out.println("进入创建订单方法CreateOrderProcessor");
    }

    @Override
    protected int getTargetStatus() {
        return OrderStatusEnum.FORMAL_EVENT.status;
    }



}
