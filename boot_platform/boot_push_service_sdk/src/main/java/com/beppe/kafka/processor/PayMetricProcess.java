package com.beppe.kafka.processor;

import com.beppe.kafka.annotation.BusinessData;

@BusinessData(code="makeup-",type = "mq",topic = "payment_ok_topic")
public class PayMetricProcess {
}
