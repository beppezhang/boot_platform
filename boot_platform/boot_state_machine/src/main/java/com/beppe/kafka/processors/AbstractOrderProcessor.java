package com.beppe.kafka.processors;

import com.beppe.kafka.constant.OrderEventImpl;
import com.beppe.kafka.constant.OrderStatusEnum;
import com.beppe.kafka.entity.Order;
import com.beppe.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOrderProcessor implements OrderProcessor {

    @Autowired
    private PayService payService;

    @Override
    public void handle(OrderEventImpl orderEvent) {
        payService.doPay();
        System.out.println("开始进入状态处理器抽象类");
        //  校验订单状态   比较订单状态  源状态是否服务预期
        Order order = orderEvent.getOrderContext().getOrder();
        // 获取源状态
        int sourceStatus = order.getOrderStatus();
        // 获取目标状态
        int targetStatus = getTargetStatus();
        // 校验状态
        boolean flag = validateStatus(sourceStatus, targetStatus);
        // 执行状态流转
        if(!flag){
            System.out.println("状态校验异常");
        }
        doProcess(orderEvent);
        System.out.println("处理器抽象类执行完成");
    }

    abstract void doProcess(OrderEventImpl orderEvent);

    protected int getTargetStatus() {
        return 0;
    }

    private boolean validateStatus(int sourceStatus, int targetStatus) {
        boolean finalStatus = isFinalStatus(sourceStatus);
        if(finalStatus){
            System.out.println("状态为最终状态");
            return false;
        }
        // 前置状态是否为源状态
        OrderStatusEnum anEnum = OrderStatusEnum.getEnum(targetStatus);
        List<Integer> previousStatus = getPreviousStatus(anEnum);
        if(!previousStatus.contains(sourceStatus)){
            System.out.println("要变更到的目标状态的前置状态异常");
            return false;
        }
        return true;
    }

    private boolean isFinalStatus(int sourceStatus) {
        if (sourceStatus == OrderStatusEnum.ORDER_FINISHED.status) {
            return true;
        }
        return false;
    }

    private List<Integer> getPreviousStatus(OrderStatusEnum status) {
        List<Integer> previousStatus = new ArrayList<>();
        switch (status) {
            case FORMAL_EVENT:
                previousStatus.add(OrderStatusEnum.CREATE_EVENT.status);
                break;
            case PAY_DONE:
                previousStatus.add(OrderStatusEnum.FORMAL_EVENT.status);
                break;

            case ORDER_CANCEL:
                previousStatus.add(OrderStatusEnum.FORMAL_EVENT.status);
                break;

            case ORDER_SHIPMENT_OK:
                previousStatus.add(OrderStatusEnum.PAY_DONE.status);
                break;

            case ORDER_FINISHED:
                previousStatus.add(OrderStatusEnum.ORDER_CANCEL.status);
                previousStatus.add(OrderStatusEnum.ORDER_SHIPMENT_OK.status);
                break;
            default:

        }
        return previousStatus;
    }

}
