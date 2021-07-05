package com.beppe.processor;

import com.beppe.annotation.BusinessData;

// 添加注解来表明 需要发消息  还是mq  以及发送的topic
@BusinessData(type = "mq",topic = "payment_ok_topic")
public class RiskStrategyProcess implements Processor {
}
