package com.beppe.yonghui;

import com.beppe.Application;
import com.yonghui.common.util.JsonUtils;
import com.yonghui.order.component.center.api.CalculateAppointmentTimeService;
import com.yonghui.order.component.center.api.CalculateDeliveryTimeService;
import com.yonghui.order.component.center.dto.fullfill.AppointmentTimeResponse;
import com.yonghui.order.component.center.dto.fullfill.ComponentOrderEntity;
import com.yonghui.order.component.center.dto.fullfill.ReplaceAppointmentTimeRequest;
import com.yonghui.trade.model.Order;
import com.yonghui.trade.model.OrderSectionFlag;
import com.yonghui.trade.service.api.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class componentService {

//    @Reference(version = "1.0",url="dubbo://127.0.0.1:32474",group = "zhangsl")
//    CalculateAppointmentTimeService calculateAppointmentTimeService;

    @Reference(version = "1.0",url="dubbo://127.0.0.1:30100",group = "zhangsl")
    CalculateDeliveryTimeService calculateDeliveryTimeService;

    @Reference(version = "1.0")
    private OrderService orderService;

//    @Test
//    public void calTime() {
//        ReplaceAppointmentTimeRequest replaceAppointmentTimeRequest = ReplaceAppointmentTimeRequest.builder().build();
//        replaceAppointmentTimeRequest.setLatitude(26.111557);
//        replaceAppointmentTimeRequest.setLongitude(119.293480);
//        replaceAppointmentTimeRequest.setOrderId(1203592000096220l);
//        replaceAppointmentTimeRequest.setReceiverAddr("今天");
//        replaceAppointmentTimeRequest.setReceiverArea("永辉超市(屏西店)");
//        replaceAppointmentTimeRequest.setReceiverCity("福州");
//        AppointmentTimeResponse customerReplaceInfoNew = calculateAppointmentTimeService.getCustomerReplaceInfoNew(replaceAppointmentTimeRequest);
//        System.out.println("时间:"+JsonUtils.toJsonString(customerReplaceInfoNew));
//    }

    @Test
    public void test1() throws ParseException {
        OrderSectionFlag orderSectionFlag = new OrderSectionFlag();
        orderSectionFlag.setIncludingOrderItems(true);
        orderSectionFlag.setIncludingOrderHeader(true);
        orderSectionFlag.setIncludingOrderDelivery(true);
        Order order = orderService.findByOrderIdForOms(1202021710022036l, orderSectionFlag);
        String s= "2023-04-23 11:32:15";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(s);
        ComponentOrderEntity componentOrderEntity = new ComponentOrderEntity();
        componentOrderEntity.setOrderDelivery(order.getOrderDelivery());
        componentOrderEntity.setUnderlyingOrderItems(order.getUnderlyingOrderItems());
        componentOrderEntity.setOrderHeader(order.getOrderHeader());
        componentOrderEntity.setOrderId(order.getOrderId());
//        ComponentOrderEntity order1 = (ComponentOrderEntity) order;
        calculateDeliveryTimeService.calculateDeliveryTimeNew(parse,componentOrderEntity,null);
    }

}
