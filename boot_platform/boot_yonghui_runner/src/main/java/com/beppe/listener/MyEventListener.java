package com.beppe.listener;

import com.beppe.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件 监听器
 */
@Slf4j
@Component
public class MyEventListener {
    //
    @Async
    @EventListener
    public void onMessage(MyEvent eventMsg) throws InterruptedException {
        log.info("subscribe message :{},线程:{}", eventMsg.getMessage(),Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("事件执行结束");
    }

    @Async
    @EventListener
    public void onMessage2(MyEvent eventMsg) throws InterruptedException {
        log.info("subscribe message2 :{},线程:{}", eventMsg.getMessage(),Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("事件执行结束2");
    }

}
