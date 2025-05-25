package com.beppe.kafka.concurrent;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo {


    @Test
    public void test1(){
        Thread.State state = Thread.currentThread().getState();
        LockSupport.park();
    }

    // 糖果的数量
    @Test
    public void test2() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000000);
    }


    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity = 10;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() == capacity) {
                    wait();
                }
                System.out.println("Producer produced: " + value);
                buffer.add(value++);
                notify();
                Thread.sleep(100);
            }
        }
    }

    public void consume() throws InterruptedException {

        while (true) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait();
                }
                int value = buffer.removeFirst();
                System.out.println("Consumer consumed: " + value);
                notify();
                Thread.sleep(100);
            }
        }
    }

    @Test
    public void test3() throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
        // 使用BlockedQueue  实现生产消费
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 生产者
                while (true){
                    try {
                        queue.put("生产一个糖");
                        System.out.println("生产一个糖,还可以生产："+(5-queue.size()));
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        queue.take();
                        System.out.println("消费了一个,还有："+(queue.size()));
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(100000);
    }

    @Test
    public void test4() throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is t1 running");
//                try {
////                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is t2 running");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t2.join();
        System.out.println("this is main running");


    }

    @Test
    public void test5(){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 2000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 5; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("this is execute");
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is execute");
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        poolExecutor.shutdown();
    }

    @Test
    public void test6()  {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<String>(10);
        System.out.println("start");
        ReentrantLock lock =new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean b = lock.tryLock();

        System.out.println("bb:"+b);
    }

    @Test
    public void test7(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("sleep结束");
                }

            }
        });
        t1.start();
        t1.interrupt();
        System.out.println("开始执行主线程");
    }
}
