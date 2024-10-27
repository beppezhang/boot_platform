package com.beppe.kafka.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author : beppe
 * @date : 2019/10/11 1:46
 * className: ZookeeperClient
 * description: ZookeeperClient 原生版客户端连接
 */
public class ZookeeperClient {


    public static class ConnectionWatch implements Watcher {

        CountDownLatch countDownLatch;

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println("连接成功了");
            countDownLatch.countDown();
        }
    }


    public static void main(String[] args) throws Exception {

        // 定义客户端连接的地址
        String address = "localhost:2181";

        // 定义 CountDownLatch 用来阻塞线程等待 watch回调 一个 连接  connectionLatch  一个获取数据  dataLatch
        final CountDownLatch connectionLatch = new CountDownLatch(1);
        final CountDownLatch dataLatch = new CountDownLatch(1);


        ConnectionWatch connectionWatch = new ConnectionWatch();
        connectionWatch.setCountDownLatch(connectionLatch);

        ZooKeeper zooKeeper = new ZooKeeper(address, 4000, connectionWatch);

        // 获取状态之前阻塞
        connectionLatch.await();
        System.out.println(zooKeeper.getState());


//        zooKeeper.create("/beppe", "beppe".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//        DataWatch dataWatch = new DataWatch();
//        dataWatch.setCountDownLatch(dataLatch);
        Stat stat = new Stat();
        String result = new String(zooKeeper.getData("/beppe",true,stat));
        System.out.println(result);
        System.out.println(stat);
    }

    private static class DataWatch implements Watcher {

        CountDownLatch countDownLatch;

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void process(WatchedEvent event) {
            System.out.println("拿到值了");
            countDownLatch.countDown();
        }
    }
}
