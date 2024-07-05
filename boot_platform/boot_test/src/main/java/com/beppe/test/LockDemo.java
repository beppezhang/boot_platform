package com.beppe.test;

import com.beppe.model.LockModel;
import org.testng.annotations.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    @Test
    public void test1() throws InterruptedException {
        LockModel lockModel = new LockModel();
        Executor executor=new ThreadPoolExecutor(5,10,1000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        CountDownLatch latch = new CountDownLatch(10);
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        for (int i = 0; i < 1; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    doExecute(lockModel);
                    lock.unlock();
                    latch.countDown();
                }
            });
        }
        latch.await();
        System.out.println("结果:"+lockModel.getResult());
    }

    private void doExecute(LockModel lockModel){
        System.out.println("this is beppe"+":"+Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Lock lock = new ReentrantLock();
//        lock.lock();
        lockModel.setResult(lockModel.getResult()+5);
//        lock.unlock();
    }

    @Test
    public void test2() throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);
        semaphore.acquire();
        semaphore.release();
    }


}
