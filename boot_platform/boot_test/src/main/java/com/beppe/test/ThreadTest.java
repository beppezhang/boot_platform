package com.beppe.test;

import org.testng.annotations.Test;

import java.util.concurrent.*;

public class ThreadTest {

    // 多线程测试
    @Test
    public void test1() throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 状态开始执行："+Thread.currentThread().getState().name()+Thread.currentThread().getName());

//                try {
//                    Thread.sleep(100);
//                    System.out.println("t1 sleep："+Thread.currentThread().getState().name()+Thread.currentThread().getName());
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                // 进如wait
                synchronized (lock){
                    try {
                        lock.wait();
                        System.out.println("t1 唤醒后的状态："+Thread.currentThread().getState().name()+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        },"t1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("t2 状态开始执行："+Thread.currentThread().getState().name()+Thread.currentThread().getName());
            }
        },"t2");


        Thread.State state = t1.getState();
        System.out.println("t1 状态new："+state.name());
        t1.start();

        while (true){
            Thread.sleep(10);
            System.out.println("循环获取t1 状态："+t1.getState().name());
            // 改变t1 的waiting
            synchronized (lock){
                lock.notify();
            }
        }
//        Thread.sleep(1000);
//        Thread.State state1 = t1.getState();
//        System.out.println("t1 状态after："+state1.name());


//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }

    // 线程状态切换  join 和join 中断
    @Test
    public void test2(){
        // t1 被join后 又被中断
        Thread mainThread = Thread.currentThread();
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 状态开始执行："+Thread.currentThread().getState().name()+Thread.currentThread().getName());



            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 状态开始执行："+Thread.currentThread().getState().name()+Thread.currentThread().getName());
                // 子线程中中断主线程
                mainThread.interrupt();


            }
        },"t2");
        t1.start();
        t2.start();

        //子线程中断主线程
        try {
            t1.join();
            t2.join();
            System.out.println("主线程开始执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    // 线程池的使用   原理
    @Test
    public void test3(){

        ExecutorService executorService = new ThreadPoolExecutor(10,20,1000, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("开始执行线程");
            }
        });
    }

    @Test
    public void test4() throws InterruptedException {
        int cout=0;
            retry:
        for (;;){
            cout++;
            Thread.sleep(100);
            if(cout==5){
                break retry;
            }
            System.out.println("result:"+cout);
        }
        System.out.println("继续执行break后代码");
    }

}
