package com.beppe.test;

import com.beppe.TestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventTest {

    @Autowired
    private com.beppe.service.OrderService OrderService;

    @Test
    public void testEvent(){
        OrderService.createorder();
    }
}
