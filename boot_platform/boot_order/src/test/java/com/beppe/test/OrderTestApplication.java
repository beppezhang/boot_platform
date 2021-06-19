package com.beppe.test;

import com.beppe.fuse.OrderStateManager;
import com.beppe.service.OrderMakeUpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Mon co
 * @description
 * @time 2021/5/7 10:12 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource("classpath:orderState-config.xml")
public class OrderTestApplication {

    @Resource
    private OrderStateManager orderStateManager;

    @Autowired
    private OrderMakeUpService orderMakeUpService;

    @Test
    public void test(){
//        OrderEvent orderEvent = new OrderEventImpl("order-event-id-1");
//        orderStateManager.fireTransition(orderEvent);

//        OrderEntity orderEntity = new OrderEntity();
//        orderEntity.setOrderId("0001");
//        orderEntity.setOrderNo("order-0001");
//        orderEntity.setOrderNum("0000");
//        orderMakeUpService.confirmOrder(orderEntity);




    }
}
