package com.beppe.kafka.processor;

import com.beppe.kafka.annotation.BusinessData;

// 添加注解来表明 需要发消息  还是mq  以及发送的topic
@BusinessData(type = "mq",topic = "payment_ok_topic")
public class RiskStrategyProcess implements Processor {
}
