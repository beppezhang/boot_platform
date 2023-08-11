package com.beppe.yonghui;

import com.beppe.Application;
import com.yonghui.makeup.service.api.OrderMakeupService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocalMakeupService {



    @Reference(version = "1.0",url="dubbo://127.0.0.1:30300",group = "zhangsl")
    OrderMakeupService orderMakeupService;





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



//        orderMakeupService.confirmOrder();

    }



}
