package com.beppe.processors;

import com.beppe.constant.OrderEventImpl;

public interface OrderProcessor {

    void handle(OrderEventImpl orderEvent);
}
