package com.beppe.listener;

import com.beppe.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件 监听器
 */
@Slf4j
@Component
public class MyEventListener {
    //
    @EventListener
    public void onMessage(MyEvent eventMsg) {
        log.info("subscribe message :{}", eventMsg.getMessage());
    }

}
