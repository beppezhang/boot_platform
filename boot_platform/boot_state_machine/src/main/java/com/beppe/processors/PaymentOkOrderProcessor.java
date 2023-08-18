package com.beppe.processors;

import com.beppe.annotation.OrderProcess;
import com.beppe.constant.OrderEvent;
import com.beppe.constant.OrderEventImpl;
import com.beppe.constant.OrderStatusEnum;
import org.springframework.stereotype.Component;

@Component
@OrderProcess(event = OrderEvent.EVT_PEYMENT_ORDER)
public class PaymentOkOrderProcessor extends AbstractOrderProcessor{


    @Override
    public  void doProcess(OrderEventImpl orderEvent){
        System.out.println("进入订单支付事件的执行PaymentOkOrderProcessor");
    }

    @Override
    protected int getTargetStatus() {
        return OrderStatusEnum.PAY_DONE.status;
    }
}
