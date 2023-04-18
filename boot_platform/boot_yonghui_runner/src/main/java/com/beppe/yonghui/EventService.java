package com.beppe.yonghui;

import com.beppe.Application;
import com.beppe.event.MyEvent;
import com.beppe.event.MyEventPublisher;
import com.google.common.collect.Lists;
import com.yonghui.makeup.client.dto.SplitOuterOrderCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventService {

    @Autowired
    private MyEventPublisher publisher;

    @Test
    public void testOuterOrderSplit(){
        MyEvent event = new MyEvent(this,"this is beppe");
        MyEvent event2 = new MyEvent(this,"this is beppe22");
        MyEvent event3 = new MyEvent(this,"this is beppe33");
        publisher.publishEvent(event);
        publisher.publishEvent(event2);
        publisher.publishEvent(event3);
    }




}
