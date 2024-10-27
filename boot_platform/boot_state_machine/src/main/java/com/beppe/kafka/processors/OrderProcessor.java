package com.beppe.kafka.processors;

import com.beppe.kafka.constant.OrderEventImpl;

public interface OrderProcessor {

    void handle(OrderEventImpl orderEvent);
}
