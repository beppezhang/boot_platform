package com.beppe.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author beppe
 * @data 2020/12/16 17:00
 * @description :
 */
@Slf4j
@Component
public class Consumer {

    @KafkaListener(topics = "beppe")
    public void consumer(ConsumerRecord<?,?> consumerRecord) {
//        Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
//        if (kafkaMassage.isPresent()) {
//            Object o = kafkaMassage.get();
//                System.out.println(o + "" + consumerRecord.partition());
//        }
        log.info("get msg key: {}, value: {}, partition: {}", consumerRecord.key(), consumerRecord.value().toString(), consumerRecord.partition());
    }
}
