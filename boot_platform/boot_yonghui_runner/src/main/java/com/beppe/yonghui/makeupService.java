package com.beppe.yonghui;

import com.alibaba.fastjson.JSONObject;
import com.beppe.Application;
import com.beppe.model.OrderItemPromotionRequest;
import com.google.common.collect.Lists;
import com.yonghui.common.util.JsonUtils;
import com.yonghui.makeup.client.api.TradeOrderSplitService;
import com.yonghui.makeup.client.dto.SplitOuterOrderCommand;
import com.yonghui.makeup.service.api.OrderAfterSaleService;
import com.yonghui.makeup.service.model.OrderRefundDTO;
import com.yonghui.makeup.service.model.OrderRefundVO;
import com.yonghui.order.component.center.api.CalculateAppointmentTimeService;
import com.yonghui.order.component.center.api.CalculateDeliveryTimeService;
import com.yonghui.order.component.center.dto.fullfill.AppointmentTimeRequest;
import com.yonghui.order.component.center.dto.fullfill.AppointmentTimeResponse;
import com.yonghui.order.component.center.dto.fullfill.ComponentDeliveryTimeInfo;
import com.yonghui.order.component.center.dto.fullfill.ComponentDeliveryTimeQuery;
import com.yonghui.promotion.service.api.PromotionApiService;
import com.yonghui.promotion.service.model.CalculateType;
import com.yonghui.promotion.service.model.PromotionCalculateDto;
import com.yonghui.promotion.service.model.PromotionCalculationOptions;
import com.yonghui.promotion.service.model.PromotionOrderDto;
import com.yonghui.trade.model.Order;
import com.yonghui.trade.model.OrderSectionFlag;
import com.yonghui.trade.service.api.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class makeupService {

    @Reference(version = "1.0")
    CalculateAppointmentTimeService calculateAppointmentTimeService;

    @Reference(version = "1.0")
    private OrderAfterSaleService orderAfterSaleService;

    @Reference(version = "1.0")
    private CalculateDeliveryTimeService calculateDeliveryTimeService;

    @Reference(version = "1.0")
    private PromotionApiService promotionApiService;

    @Reference(version = "1.0")
    private OrderService orderService;

    @Reference(version = "1.0")
    private TradeOrderSplitService tradeOrderSplitService;


//    @Test
//    public void test() {
//        AppointmentTimeRequest.ComponentOptions componentOptions = AppointmentTimeRequest.ComponentOptions.builder().bargainDeliveryDays(null)
//                .newPresaleFlag(false).isReservation(false).isVoidance(false).
//                        isOnlyImmediate(false)
//                .isBatch(false).build();
//        AppointmentTimeRequest.ComponentOrderHeader componentOrderHeader = AppointmentTimeRequest.ComponentOrderHeader.builder().memberId(940898958971431143l).businessFlag(null)
//                .orderShopId("9529")
//                .orderType("")
//                .orderSubType("").build();
//
//        AppointmentTimeRequest.ComponentOrderDelivery componentOrderDelivery = AppointmentTimeRequest.ComponentOrderDelivery.builder().latitude(Double.parseDouble("34")).longitude(Double.parseDouble("109"))
//                .receiverCity("福州").
//                        receiverArea("鼓楼").
//                        receiverAddr("5号楼601").build();
//
//        AppointmentTimeRequest.ComponentOrderItem item = AppointmentTimeRequest.ComponentOrderItem.builder().bomType(1).categoryId("23445")
//                .qty(new BigDecimal(2)).goodsId("B-223443").skuDeliveryType(1)
//                .grossWeight(new BigDecimal(2)).build();
//        AppointmentTimeRequest appointmentTimeRequest = AppointmentTimeRequest.builder().deliverType(1).fenceType(0).orderId(0l).
//                freshTypes(null).shopId("9529").skuItemList(Lists.newArrayList(item))
//                .componentOptions(componentOptions).componentOrderHeader(componentOrderHeader)
//                .componentOrderDelivery(componentOrderDelivery).build();
//
//        AppointmentTimeResponse response = calculateAppointmentTimeService.calculateTimeForOMS(appointmentTimeRequest);
//        System.out.println("appointmentTimeResponses:" + JsonUtils.toJsonString(response));
//    }

    @Test
    public void testRefoud(){
        OrderRefundDTO orderRefundDTO = new OrderRefundDTO();
        orderRefundDTO.setAfterSalesOrderId(1659522385330655L);
        orderRefundDTO.setRootOrderId(1208832300028220L);
        orderRefundDTO.setParentOrderId(1208832300028220L);

        List<OrderRefundDTO.RefundItem> refundItems = new ArrayList<>();
        OrderRefundDTO.RefundItem refundItem = new OrderRefundDTO.RefundItem();
        refundItem.setType(1); //换货
        refundItem.setOrderItemId(1208832300028220001L); //待换商品行
        refundItem.setSkuCode("B-157475"); //待换商品编码
        refundItem.setNum(new BigDecimal(1)); //待换数量
        OrderRefundDTO.ExchangeItem exchangeItem = new OrderRefundDTO.ExchangeItem();
        exchangeItem.setSkuCode("B-1010669"); //换成商品编码
        exchangeItem.setNum(new BigDecimal(1)); //换货数量
        refundItem.setExchangeItem(exchangeItem);
        refundItems.add(refundItem);
        orderRefundDTO.setRefundItems(refundItems);
        OrderRefundVO orderRefundVO = orderAfterSaleService.refund(orderRefundDTO);

        System.out.println("响应成功结果"+ JSONObject.toJSONString(orderRefundVO));
    }

    @Test
    public void test2(){
        ComponentDeliveryTimeQuery componentDeliveryTimeQuery = new ComponentDeliveryTimeQuery();
        componentDeliveryTimeQuery.setShopId("9010");
        componentDeliveryTimeQuery.setOfsType(3);
        ComponentDeliveryTimeInfo componentDeliveryTimeInfo = calculateDeliveryTimeService.calculateDeliveryTime(componentDeliveryTimeQuery);
        System.out.println("reslut:"+JsonUtils.toJsonString(componentDeliveryTimeInfo));
    }

    @Test
    public void test3(){
        PromotionCalculateDto promotionCalculateDto = initPromotionCalculateDto();
        PromotionOrderDto promotionOrderDto = promotionApiService.calculate4ExchangeGoods(promotionCalculateDto);
        System.out.println("promotionOrderDto:"+JsonUtils.toJsonString(promotionOrderDto));
    }

    private PromotionCalculateDto initPromotionCalculateDto(){
        OrderSectionFlag orderSectionFlag = new OrderSectionFlag();
        orderSectionFlag.setIncludingOrderHeader(true);
        orderSectionFlag.setIncludingOrderItems(true);
        Order order = orderService.findByOrderIdForOms(1200892500016240l, orderSectionFlag);
        PromotionCalculateDto promotionCalculateDto = new PromotionCalculateDto();
        PromotionOrderDto promotionOrderDto = new PromotionOrderDto();
        PromotionCalculateDto.CalculateContext calculateContext = new PromotionCalculateDto().new CalculateContext();
        calculateContext.setOptions(new PromotionCalculationOptions());
        calculateContext.setEvaluate(false);
        calculateContext.setCalculateType(CalculateType.CONFIRM);
        promotionOrderDto.setOrderHeader(order.getOrderHeader());
        promotionOrderDto.setUnderlyingOrderItems(order.getUnderlyingOrderItems());
        promotionCalculateDto.setPromotionOrderEntity(promotionOrderDto);
        promotionCalculateDto.setCalculateContext(calculateContext);
        return promotionCalculateDto;

    }


    @Test
    public void testOuterOrderSplit(){
        SplitOuterOrderCommand.SplitOrderItem item1 = SplitOuterOrderCommand.SplitOrderItem.builder().orderItemId(1209252100065260003l).qty(new BigDecimal(1)).build();
        SplitOuterOrderCommand.SplitOrderItem item2 = SplitOuterOrderCommand.SplitOrderItem.builder().orderItemId(1209252100065260004l).qty(new BigDecimal(1)).build();
        SplitOuterOrderCommand.SplitOrderItem item3 = SplitOuterOrderCommand.SplitOrderItem.builder().orderItemId(1209252100065260005l).qty(new BigDecimal(1)).build();
        List<SplitOuterOrderCommand.SplitOrderItem> splitOrderItems1 = Lists.newArrayList(item1,item2,item3);
        List<SplitOuterOrderCommand.SplitOrderItem> splitOrderItems2=Lists.newArrayList(SplitOuterOrderCommand.SplitOrderItem.builder().orderItemId(1209252100065260006l).qty(new BigDecimal(0.8)).build());
        List<SplitOuterOrderCommand.SplitChildOrder> orders = Lists.newArrayList();
        orders.add(SplitOuterOrderCommand.SplitChildOrder.builder().orderType(5).outerOrderId("33344").splitOrderItems(splitOrderItems1).build());
        orders.add(SplitOuterOrderCommand.SplitChildOrder.builder().orderType(5).outerOrderId("99888").splitOrderItems(splitOrderItems2).build());
        SplitOuterOrderCommand build = SplitOuterOrderCommand.builder().orderId(1209252100065260l).splitChildOrders(orders).operator("system").build();
        tradeOrderSplitService.outerOrderSplit(build);
    }

}
