package com.beppe.kafka.statemachine.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;

/**
 * @author beppe
 * @data 2020/12/16 17:54
 * @description :
 */
@Slf4j
public class MySelfPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes,
                         Object value, byte[] valueBytes, Cluster cluster) {
        log.info("use MySelfPartitioner ...");
        //拿到主题中的分区信息
        List<PartitionInfo> partitionInfos = cluster.partitionsForTopic(topic);
        //获取分区数
        int num = partitionInfos.size();
        //计算value的hashcode，然后取模，获取一个分区
        int parId = value.hashCode()%num;
        return parId;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
