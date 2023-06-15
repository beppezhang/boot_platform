package com.beppe.yonghui;

import com.alibaba.fastjson.JSONObject;
import com.beppe.Application;
import com.yonghui.common.util.JsonUtils;
import com.yonghui.makeup.service.api.LocalRpcService;
import com.yonghui.makeup.service.api.OrderMakeupService;
import com.yonghui.order.guarantee.center.api.GuaranteeService;
import com.yonghui.order.guarantee.center.dto.GuaranteeDTO;
import com.yonghui.order.guarantee.center.enums.GuaranteeBizTypeEnum;
import com.yonghui.shopping.cart.service.dto.CartUpdateRequest;
import com.yonghui.shopping.cart.service.dto.MultiCartInfo;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShoppingCartService {

//    @Reference(version = "1.0",url="dubbo://127.0.0.1:32474",group = "zhangsl")
//    com.yonghui.shopping.cart.service.api.ShoppingCartService shoppingCartService;

    @Reference(version = "1.0",url="dubbo://127.0.0.1:30300",group = "zhangsl")
    OrderMakeupService orderMakeupService;
//
//    @Reference(version = "1.0",url="dubbo://127.0.0.1:30300",group = "zhangsl")
//    GuaranteeService guaranteeService;


    @Test
    public void test1() {
//        String requestADD="{\"cartCalculateOptions\":{\"firstPriceFlag\":false,\"multiAdditionalBuy\":true,\"valiateOrderMultiRemark\":true},\"cartMode\":20,\"cartType\":\"normal\",\"carts\":[{\"basicProducts\":[{\"amount\":0,\"goodsTagId\":3,\"notShowMultiRemark\":false,\"operateType\":0,\"orderMultiRemark\":[],\"selected\":false,\"skuCode\":\"R-944627\"}],\"seller\":\"SUPER_STORES\",\"shopId\":\"9146\"}],\"channelId\":4,\"cityId\":8,\"profile\":{\"addressId\":1011410,\"deviceId\":\"B3D44A7A-CE07-4923-8139-3290FA2FA11A\",\"location\":{\"lat\":31.891494,\"lng\":117.315827},\"memberId\":251278519373638958,\"selfPickup\":false,\"superMemberFlag\":false},\"promoVerLimit\":15,\"source\":1,\"version\":\"9.5.0.12\"}";
//        String requestFresh="{\"cartCalculateOptions\":{\"firstPriceFlag\":false,\"multiAdditionalBuy\":true,\"valiateOrderMultiRemark\":true},\"cartMode\":22,\"cartType\":\"normal\",\"carts\":[],\"channelId\":4,\"cityId\":8,\"profile\":{\"addressId\":1011410,\"deviceId\":\"B3D44A7A-CE07-4923-8139-3290FA2FA11A\",\"location\":{\"lat\":31.891494,\"lng\":117.315827},\"memberId\":251278519373638958,\"selfPickup\":false,\"superMemberFlag\":false},\"promoVerLimit\":15,\"source\":1,\"version\":\"9.5.0.12\"}";
////        CartUpdateRequest cartUpdateRequest = JSONObject.parseObject(requestADD, CartUpdateRequest.class);
//        CartUpdateRequest cartUpdateRequest = JSONObject.parseObject(requestFresh, CartUpdateRequest.class);
//        MultiCartInfo multiCartInfo = shoppingCartService.cartUpdate(cartUpdateRequest);
//        System.out.println("multiCartInfo:"+ JsonUtils.toJsonString(multiCartInfo));
    }

    /**
     * OperationContext context,
     *                                     OrderEntity orderEntity,
     *                                     BigDecimal priceTotal   11.00
     *
     *
     *
     *                                     ,
     *                                     OrderCalculationOptions option,
     *                                     Map<String, String> skuPromoMap,
     *                                     BalancePayValidEntity balancePayValidEntity
     */
    @Test
    public void testconfirm() {
        String contextStr="{\"operator\":\"system\"}";
        String orderEntityStr="{\n" +
                "    \"orderDelivery\": {\n" +
                "        \"customerAddrId\": 1011410,\n" +
                "        \"customerPhone1\": \"13006754998\",\n" +
                "        \"delType\": \"delivery\",\n" +
                "        \"receiverAddr\": \"合肥宝文\",\n" +
                "        \"receiverAlias\": \"公司\",\n" +
                "        \"receiverArea\": \"永辉超市(宝文店)\",\n" +
                "        \"receiverCity\": \"合肥\",\n" +
                "        \"receiverDistinct\": \"瑶海区\",\n" +
                "        \"receiverLatitude\": \"31.891494\",\n" +
                "        \"receiverLongitude\": \"117.315827\",\n" +
                "        \"receiverName\": \"测试|M\",\n" +
                "        \"receiverProvince\": \"安徽省\",\n" +
                "        \"timeSlotDate\": 1686672000000,\n" +
                "        \"timeSlotTimeFrom\": \"\",\n" +
                "        \"timeSlotTimeTo\": \"\",\n" +
                "        \"timeSlotType\": \"immediate\"\n" +
                "    },\n" +
                "    \"orderHeader\": {\n" +
                "        \"channelId\": 4,\n" +
                "        \"cityId\": 8,\n" +
                "        \"customerId\": 251278519373638958,\n" +
                "        \"customerName\": \"13006754998\",\n" +
                "        \"deviceCode\": \"B3D44A7A-CE07-4923-8139-3290FA2FA11A\",\n" +
                "        \"erpShopId\": \"9146\",\n" +
                "        \"fAfterPromoAmtAndTax\": 0,\n" +
                "        \"message\": \"\",\n" +
                "        \"orderAt\": 1686727650411,\n" +
                "        \"orderSubType\": \"normal\",\n" +
                "        \"orderTags\": [\n" +
                "            \n" +
                "        ],\n" +
                "        \"orderType\": \"sales.order\",\n" +
                "        \"pAfterPromoAmtAndTax\": 0,\n" +
                "        \"sellerId\": 7,\n" +
                "        \"shopId\": \"9146\",\n" +
                "        \"strGrayTags\": [\n" +
                "            \n" +
                "        ],\n" +
                "        \"weChatPromoAmt\": 0.00\n" +
                "    },\n" +
                "    \"orderId\": 0,\n" +
                "    \"orderItems\": [\n" +
                "        \n" +
                "    ],\n" +
                "    \"underlyingOrderItems\": [\n" +
                "        {\n" +
                "            \"afterPromoSubAmtAndTax\": 0,\n" +
                "            \"bundleItemType\": \"master\",\n" +
                "            \"bundlePromoCode\": \"ORDER1685603085413OpAWdPr--PERIOD--1\",\n" +
                "            \"fAfterPromoSubAmtAndTax\": 0,\n" +
                "            \"fxPromoSubAmtSum\": 0,\n" +
                "            \"goodsId\": \"R-993387\",\n" +
                "            \"pAfterPromoSubAmtAndTax\": 0,\n" +
                "            \"pxPromoSubAmtSum\": 0,\n" +
                "            \"qty\": 2.00,\n" +
                "            \"skuDeliveryType\": 1,\n" +
                "            \"weChatPromoSubAmtSum\": 0\n" +
                "        }\n" +
                "    ]\n" +
                "}";



        orderMakeupService.confirmOrder();

    }

    @Test
    public void test3() {

    }

}
