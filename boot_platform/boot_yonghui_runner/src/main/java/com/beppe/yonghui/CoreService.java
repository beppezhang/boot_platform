package com.beppe.yonghui;

import com.beppe.Application;
import com.google.common.collect.Lists;
import com.yonghui.common.order.OrderEvent;
import com.yonghui.order.core.api.CoreOrderToolService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoreService {

    @Reference(version = "1.0",url="dubbo://127.0.0.1:30300")
    CoreOrderToolService coreOrderToolService;




    @Test
    public void test1() {
        List<Long> ids = Lists.newArrayList(1200332000035210l);
        coreOrderToolService.orderToFinanceRepaymentMessage(ids, OrderEvent.PAYMENT_OK.getValue());
    }



}
