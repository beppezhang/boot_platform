package com.beppe.kafka.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

/**
 * @author : beppe
 * @date : 2019/10/11 1:46
 * className: CuratorClient
 * description: curator 客户端的使用 对 zookeeper 原生API 的一些封装
 */
public class CuratorClient {


    public static void main(String[] args) throws Exception {

        // 定义客户端连接的地址
        String address = "localhost:2181";

        CuratorFramework curatorFramework = CuratorFrameworkFactory.
                builder().connectString(address).sessionTimeoutMs(4000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).namespace("").build();
        curatorFramework.start();
        Stat stat = new Stat();
        //查询节点数据
        byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/beppe");
        System.out.println(new String(bytes));
        curatorFramework.close();


    }
}
