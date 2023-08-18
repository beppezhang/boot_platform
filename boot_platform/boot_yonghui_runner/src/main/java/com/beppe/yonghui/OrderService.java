package com.beppe.yonghui;

import com.beppe.Application;
import com.yonghui.common.constants.OrderDeliveryStatusEnum;
import com.yonghui.common.constants.OrderStatus;
import com.yonghui.common.order.OrderEvent;
import com.yonghui.partner.api.PartnerService;
import com.yonghui.partner.api.model.order.PartnerOrderInfo;
import com.yonghui.picklist.api.PickListOrderService;
import com.yonghui.picklist.api.PicklistService;
import com.yonghui.picklist.api.model.PickListOrder;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderService {

//    @Reference(version = "1.0")
//    com.yonghui.trade.service.api.OrderService orderServicer1;
//
//    @Reference(version = "1.0")
//    CoreOrderService coreOrderService;

    @Reference(version = "1.0")
    private PickListOrderService pickListOrderService;

    @Reference(version = "1.0")
    private PicklistService pickListService;

    @Reference(version = "1.0")
    private PartnerService partnerService;

    @Test
    public void test1() {
        partnerService.onOrderStatusChange(251278519373638958l
                , 120925609840021l, null, OrderDeliveryStatusEnum.INVENTORY_RESERVED.getValue()
                , OrderDeliveryStatusEnum.INVENTORY_RESERVED.getValue(), OrderStatus.WAITING_PAYMENT.getValue()
                , OrderStatus.IN_PROGRESS.getValue(), OrderEvent.PAYMENT_OK.getValue());
        pickListService.onOrderStatusChange(120925609840021l,OrderDeliveryStatusEnum.INVENTORY_RESERVED.getValue(), OrderDeliveryStatusEnum.INVENTORY_RESERVED.getValue(),
                OrderStatus.WAITING_PAYMENT.getValue(), OrderStatus.IN_PROGRESS.getValue(), OrderEvent.PAYMENT_OK.getValue(),"9459");
        PickListOrder pickListOrder = pickListOrderService.queryByOrderId(120925609840021l);
        PartnerOrderInfo partnerOrderInfo = partnerService.getOrder(120925609840021l);

    }

}
