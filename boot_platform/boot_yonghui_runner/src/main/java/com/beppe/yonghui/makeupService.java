package com.beppe.yonghui;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beppe.Application;
import com.beppe.model.OrderItemPromotionRequest;
import com.google.common.collect.Lists;
import com.yonghui.common.util.JsonUtils;
import com.yonghui.common.util.OperationContext;
import com.yonghui.makeup.client.api.TradeOrderSplitService;
import com.yonghui.makeup.client.dto.SplitOuterOrderCommand;
import com.yonghui.makeup.service.api.OrderAfterSaleService;
import com.yonghui.makeup.service.model.OrderRefundDTO;
import com.yonghui.makeup.service.model.OrderRefundVO;
import com.yonghui.ofs.burst.control.api.CalcPressureControlService;
import com.yonghui.ofs.burst.control.dto.CalcReservationOrderResponse;
import com.yonghui.ofs.burst.control.dto.JudgeRealtimeOrderRequest;
import com.yonghui.order.common.center.api.PurchaseOrderService;
import com.yonghui.order.common.center.dto.PurchaseIssuedDTO;
import com.yonghui.order.component.center.api.CalculateAppointmentTimeService;
import com.yonghui.order.component.center.api.CalculateDeliveryTimeService;
import com.yonghui.order.component.center.dto.fullfill.AppointmentTimeRequest;
import com.yonghui.order.component.center.dto.fullfill.AppointmentTimeResponse;
import com.yonghui.order.component.center.dto.fullfill.ComponentDeliveryTimeInfo;
import com.yonghui.order.component.center.dto.fullfill.ComponentDeliveryTimeQuery;
import com.yonghui.order.core.api.CoreOrderService;
import com.yonghui.product.model.Shop;
import com.yonghui.product.service.api.ShopService;
import com.yonghui.promotion.service.api.PromotionApiService;
import com.yonghui.promotion.service.model.CalculateType;
import com.yonghui.promotion.service.model.PromotionCalculateDto;
import com.yonghui.promotion.service.model.PromotionCalculationOptions;
import com.yonghui.promotion.service.model.PromotionOrderDto;
import com.yonghui.trade.model.Order;
import com.yonghui.trade.model.OrderItemPromotion;
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
    @Reference(version = "1.0")
    private CalcPressureControlService calcPressureControlService;

    @Reference(version = "1.0")
    private CoreOrderService coreOrderService;

    @Reference(version = "1.0")
    private PurchaseOrderService purchaseOrderService;




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
        orderRefundDTO.setRootOrderId(1209252500026250L);
        orderRefundDTO.setParentOrderId(1209252500026250L);

        List<OrderRefundDTO.RefundItem> refundItems = new ArrayList<>();
        OrderRefundDTO.RefundItem refundItem = new OrderRefundDTO.RefundItem();
        refundItem.setType(1); //换货
        refundItem.setOrderItemId(1209252500026250001l); //待换商品行
        refundItem.setSkuCode("B-1000220"); //待换商品编码
        refundItem.setNum(new BigDecimal(1)); //待换数量
        OrderRefundDTO.ExchangeItem exchangeItem = new OrderRefundDTO.ExchangeItem();
        exchangeItem.setSkuCode("B-CB61514"); //换成商品编码
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

    @Test
    public void testShop(){
        JudgeRealtimeOrderRequest judgeRealtimeOrderRequest = new JudgeRealtimeOrderRequest();
        judgeRealtimeOrderRequest.setShopId("9010");
        judgeRealtimeOrderRequest.setDeliverType(1);
        CalcReservationOrderResponse calcReservationOrderResponse = calcPressureControlService.calcJudgeReservationOrder(judgeRealtimeOrderRequest);
        System.out.println("calcReservationOrderResponse:"+JsonUtils.ToJsonString(calcReservationOrderResponse));

    }

    @Test
    public void yhCardBind(){
        coreOrderService.yhCardBind(1209252200036210l,Lists.newArrayList("2336059180008505221","2336059180008505238"));

    }

    @Test
    public void testissued(){
        PurchaseIssuedDTO purchaseIssuedDTO = new PurchaseIssuedDTO();
        purchaseIssuedDTO.setOrderId(1209252500036240L);
        purchaseIssuedDTO.setType(1);
        purchaseOrderService.issued(purchaseIssuedDTO);

    }

    @Test
    public void testrelease(){
        OperationContext operationContext = new OperationContext();
        coreOrderService.releaseToShipment(operationContext,1206002300084210l);

    }

    @Test
    public void testinsert(){
        String json = "[\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467283,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-908417\",\n" +
                "            \"id\":1206701900013085001,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085001,\n" +
                "            \"pPromoAmt\":2,\n" +
                "            \"promoSubType\":\"new-price\",\n" +
                "            \"promoType\":\"I\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"activity_GOODS1675332812139AlymrZW_263695422--PERIOD--1\",\n" +
                "            \"rowNum\":0,\n" +
                "            \"updatedAt\":1676033467283,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467284,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1314495\",\n" +
                "            \"id\":1206701900013085002,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085002,\n" +
                "            \"pPromoAmt\":3,\n" +
                "            \"promoSubType\":\"自建秒杀\",\n" +
                "            \"promoType\":\"I\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"activity_zijian201-228_264580488\",\n" +
                "            \"rowNum\":1,\n" +
                "            \"updatedAt\":1676033467284,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467287,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-938331\",\n" +
                "            \"id\":1206701900013085003,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085004,\n" +
                "            \"pPromoAmt\":7.9,\n" +
                "            \"promoSubType\":\"new-price\",\n" +
                "            \"promoType\":\"I\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"activity_GOODS1675154458428OYwShvb_262765076--PERIOD--1\",\n" +
                "            \"rowNum\":3,\n" +
                "            \"updatedAt\":1676033467287,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467289,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1276414\",\n" +
                "            \"id\":1206701900013085004,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085005,\n" +
                "            \"pPromoAmt\":5,\n" +
                "            \"promoSubType\":\"new-price\",\n" +
                "            \"promoType\":\"I\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"activity_GOODS1675154458428OYwShvb_262764352--PERIOD--1\",\n" +
                "            \"rowNum\":4,\n" +
                "            \"updatedAt\":1676033467289,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467290,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1276413\",\n" +
                "            \"id\":1206701900013085005,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085006,\n" +
                "            \"pPromoAmt\":5,\n" +
                "            \"promoSubType\":\"new-price\",\n" +
                "            \"promoType\":\"I\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"activity_GOODS1675154458428OYwShvb_262764351--PERIOD--1\",\n" +
                "            \"rowNum\":5,\n" +
                "            \"updatedAt\":1676033467290,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467292,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1149992\",\n" +
                "            \"id\":1206701900013085006,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085007,\n" +
                "            \"pPromoAmt\":1.1,\n" +
                "            \"promoSubType\":\"new-price\",\n" +
                "            \"promoType\":\"I\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"activity_GOODS1675994747069lRedFjO_265560302--PERIOD--1\",\n" +
                "            \"rowNum\":6,\n" +
                "            \"updatedAt\":1676033467292,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467294,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1576097\",\n" +
                "            \"id\":1206701900013085007,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085008,\n" +
                "            \"pPromoAmt\":5.91,\n" +
                "            \"promoSubType\":\"new-price\",\n" +
                "            \"promoType\":\"I\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"activity_GOODS1675935300296wtmxNhO_265424472--PERIOD--1\",\n" +
                "            \"rowNum\":7,\n" +
                "            \"updatedAt\":1676033467294,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467296,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CBS1069833-RE1\",\n" +
                "            \"id\":1206701900013085008,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085009,\n" +
                "            \"pPromoAmt\":2.5,\n" +
                "            \"promoSubType\":\"new-price\",\n" +
                "            \"promoType\":\"I\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"activity_GOODS1671863856487jDyCnCe_251509933--PERIOD--1\",\n" +
                "            \"rowNum\":8,\n" +
                "            \"updatedAt\":1676033467296,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-908417\",\n" +
                "            \"id\":1206701900013085009,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085001,\n" +
                "            \"pPromoAmt\":0.81,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":0,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1314495\",\n" +
                "            \"id\":1206701900013085010,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085002,\n" +
                "            \"pPromoAmt\":0.5,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":1,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CB54098303\",\n" +
                "            \"id\":1206701900013085011,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085003,\n" +
                "            \"pPromoAmt\":0.28,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":2,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-938331\",\n" +
                "            \"id\":1206701900013085012,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085004,\n" +
                "            \"pPromoAmt\":1.19,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":3,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1276414\",\n" +
                "            \"id\":1206701900013085013,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085005,\n" +
                "            \"pPromoAmt\":0.79,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":4,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1276413\",\n" +
                "            \"id\":1206701900013085014,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085006,\n" +
                "            \"pPromoAmt\":0.79,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":5,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1149992\",\n" +
                "            \"id\":1206701900013085015,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085007,\n" +
                "            \"pPromoAmt\":0.49,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":6,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1576097\",\n" +
                "            \"id\":1206701900013085016,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085008,\n" +
                "            \"pPromoAmt\":0.8,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":7,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CBS1069833-RE1\",\n" +
                "            \"id\":1206701900013085017,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085009,\n" +
                "            \"pPromoAmt\":0.35,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":8,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.81,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-908417\",\n" +
                "            \"id\":1206701900013085018,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085001,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":0,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.5,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1314495\",\n" +
                "            \"id\":1206701900013085019,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085002,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":1,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.28,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CB54098303\",\n" +
                "            \"id\":1206701900013085020,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085003,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":2,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":1.19,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-938331\",\n" +
                "            \"id\":1206701900013085021,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085004,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":3,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.79,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1276414\",\n" +
                "            \"id\":1206701900013085022,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085005,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":4,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.79,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1276413\",\n" +
                "            \"id\":1206701900013085023,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085006,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":5,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.49,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1149992\",\n" +
                "            \"id\":1206701900013085024,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085007,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":6,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.8,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-1576097\",\n" +
                "            \"id\":1206701900013085025,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085008,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":7,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.35,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CBS1069833-RE1\",\n" +
                "            \"id\":1206701900013085026,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085009,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":8,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085027,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085001,\n" +
                "            \"pPromoAmt\":0.66,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085028,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085002,\n" +
                "            \"pPromoAmt\":0.42,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085029,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085003,\n" +
                "            \"pPromoAmt\":0.23,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085030,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085004,\n" +
                "            \"pPromoAmt\":1,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085031,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085005,\n" +
                "            \"pPromoAmt\":0.66,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085032,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085006,\n" +
                "            \"pPromoAmt\":0.66,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085033,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085007,\n" +
                "            \"pPromoAmt\":0.41,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085034,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085008,\n" +
                "            \"pPromoAmt\":0.67,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085035,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085009,\n" +
                "            \"pPromoAmt\":0.29,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CB54098303\",\n" +
                "            \"id\":1206701900013085036,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085010,\n" +
                "            \"pPromoAmt\":0.28,\n" +
                "            \"parentBomOrderItemId\":1206701900013085003,\n" +
                "            \"parentBomOrderItemPromoId\":1206701900013085011,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":2,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.28,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CB54098303\",\n" +
                "            \"id\":1206701900013085037,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085010,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"parentBomOrderItemId\":1206701900013085003,\n" +
                "            \"parentBomOrderItemPromoId\":1206701900013085020,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":2,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085038,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085010,\n" +
                "            \"pPromoAmt\":0.23,\n" +
                "            \"parentBomOrderItemId\":1206701900013085003,\n" +
                "            \"parentBomOrderItemPromoId\":1206701900013085029,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467296,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CBS1069833-RE1\",\n" +
                "            \"id\":1206701900013085039,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085011,\n" +
                "            \"pPromoAmt\":2.5,\n" +
                "            \"parentBomOrderItemId\":1206701900013085009,\n" +
                "            \"parentBomOrderItemPromoId\":1206701900013085008,\n" +
                "            \"promoSubType\":\"new-price\",\n" +
                "            \"promoType\":\"I\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"activity_GOODS1671863856487jDyCnCe_251509933--PERIOD--1\",\n" +
                "            \"rowNum\":8,\n" +
                "            \"updatedAt\":1676033467296,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"13\",\n" +
                "            \"couponCode\":\"000004656794674\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CBS1069833-RE1\",\n" +
                "            \"id\":1206701900013085040,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085011,\n" +
                "            \"pPromoAmt\":0.35,\n" +
                "            \"parentBomOrderItemId\":1206701900013085009,\n" +
                "            \"parentBomOrderItemPromoId\":1206701900013085017,\n" +
                "            \"promoSubType\":\"CashReduction\",\n" +
                "            \"promoType\":\"OrderCoupon\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"1-Q59\",\n" +
                "            \"rowNum\":8,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":-1,\n" +
                "            \"costCenterNo\":\"-1\",\n" +
                "            \"createdAt\":1676033467310,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"deleteFlag\":0,\n" +
                "            \"fPromoAmt\":0.35,\n" +
                "            \"fromEcc\":false,\n" +
                "            \"goodsId\":\"R-CBS1069833-RE1\",\n" +
                "            \"id\":1206701900013085041,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085011,\n" +
                "            \"pPromoAmt\":0,\n" +
                "            \"parentBomOrderItemId\":1206701900013085009,\n" +
                "            \"parentBomOrderItemPromoId\":1206701900013085026,\n" +
                "            \"promoSubType\":\"freight.free.if.threshold.meet\",\n" +
                "            \"promoType\":\"S\",\n" +
                "            \"promotionCategory\":\"rule\",\n" +
                "            \"promotionCode\":\"FJ-YF-210\",\n" +
                "            \"rowNum\":8,\n" +
                "            \"updatedAt\":1676033467310,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        },\n" +
                "        {\n" +
                "            \"costCenter\":12,\n" +
                "            \"costCenterNo\":\"12\",\n" +
                "            \"couponMode\":0,\n" +
                "            \"createdAt\":1676033467359,\n" +
                "            \"createdBy\":\"system\",\n" +
                "            \"fPromoAmt\":0,\n" +
                "            \"id\":1206701900013085042,\n" +
                "            \"orderId\":1206701900013085,\n" +
                "            \"orderItemId\":1206701900013085011,\n" +
                "            \"pPromoAmt\":0.29,\n" +
                "            \"parentBomOrderItemId\":1206701900013085009,\n" +
                "            \"parentBomOrderItemPromoId\":1206701900013085035,\n" +
                "            \"promotionCategory\":\"point\",\n" +
                "            \"updatedAt\":1676033467359,\n" +
                "            \"updatedBy\":\"system\",\n" +
                "            \"version\":2\n" +
                "        }\n" +
                "    ]";




    }



}
