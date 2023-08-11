package com.beppe.yonghui;

import com.alibaba.fastjson.JSONObject;
import com.beppe.Application;
import com.yonghui.common.util.JsonUtils;
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

    @Reference(version = "1.0",url="dubbo://127.0.0.1:32474",group = "zhangsl")
    com.yonghui.shopping.cart.service.api.ShoppingCartService shoppingCartService;




    @Test
    public void test1() {
        String requestADD="{\"cartCalculateOptions\":{\"firstPriceFlag\":false,\"multiAdditionalBuy\":true,\"valiateOrderMultiRemark\":true},\"cartMode\":20,\"cartType\":\"normal\",\"carts\":[{\"basicProducts\":[{\"amount\":0,\"goodsTagId\":0,\"notShowMultiRemark\":false,\"operateType\":0,\"orderMultiRemark\":[{\"amount\":2}],\"orderRemark\":\"07月24日上市 23:30前可配送\",\"selected\":true,\"skuCode\":\"B-CBS11022-RE2\"}],\"seller\":\"BRAVO\",\"shopId\":\"9010\"}],\"channelId\":4,\"cityId\":4,\"profile\":{\"addressId\":1001983,\"deviceId\":\"B3D44A7A-CE07-4923-8139-3290FA2FA11A\",\"location\":{\"lat\":26.111027,\"lng\":119.294403},\"memberId\":251278519373638958,\"selfPickup\":false,\"superMemberFlag\":false},\"promoVerLimit\":15,\"source\":1,\"version\":\"9.5.0.12\"}";
//        String requestFresh="{\"cartCalculateOptions\":{\"firstPriceFlag\":true,\"multiAdditionalBuy\":true,\"valiateOrderMultiRemark\":true},\"cartMode\":22,\"cartType\":\"normal\",\"carts\":[],\"channelId\":4,\"profile\":{\"addressId\":0,\"deviceId\":\"C05DCCE0-503D-4C7A-8CDD-5E900A2D5399\",\"location\":{\"lat\":26.111557,\"lng\":119.293481},\"memberId\":759712686710290686,\"selfPickup\":false,\"superMemberFlag\":false},\"promoVerLimit\":15,\"version\":\"9.7.10.9\"}";
////        CartUpdateRequest cartUpdateRequest = JSONObject.parseObject(requestADD, CartUpdateRequest.class);
        CartUpdateRequest cartUpdateRequest = JSONObject.parseObject(requestADD, CartUpdateRequest.class);
        MultiCartInfo multiCartInfo = shoppingCartService.cartUpdate(cartUpdateRequest);
        System.out.println("multiCartInfo:"+ JsonUtils.toJsonString(multiCartInfo));
    }



}
