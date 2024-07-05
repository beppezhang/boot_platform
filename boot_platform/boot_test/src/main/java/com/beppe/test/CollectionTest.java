package com.beppe.test;

import com.beppe.entity.Order;
import com.beppe.model.LockModel;
import org.joda.time.LocalDateTime;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

public class CollectionTest {

    @Test
    public void test1(){
//        List<String> list=new ArrayList();
//        list.add("beppe1");
//        list.add("beppe2");
//        list.add("beppe3");
//        list.get(0);
//        System.out.println("list:"+list);
//        list.add(0,"beppe4");
//        System.out.println("after:"+list);
        int i = 16&0;
        System.out.println("aa:"+i);
//        List<String> list = new Vector<>();
//        list.add("aaa");
    }

    @Test
    public void test2() throws InterruptedException {
//        Map<String, String> map = new HashMap<>();
//        for (int i = 0; i < 40; i++) {
//            map.put("name"+i,"beppe"+i);
//        }
//        for (int i = 40; i < 58; i++) {
//            map.put("name"+i,"beppe"+i);
//        }
//        Map map=new LinkedHashMap();
//        map.put("name","beppe");
//        System.out.println("aa:"+map);
//
//        Map map1= new ConcurrentHashMap<>();
//        map1.put("name","aa");
//        Object name = map1.get("name");
//
//        AtomicInteger atomicInteger = new AtomicInteger(2);
//        int i = atomicInteger.addAndGet(2);
//        atomicInteger.get();
//
//        AtomicLong atomicLong = new AtomicLong(4);
        LockModel lockModel = new LockModel();
        Executor executor=new ThreadPoolExecutor(5,10,1000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        CountDownLatch latch = new CountDownLatch(10);
        Lock lock = new ReentrantLock();
        lock.lock();
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


//        Thread.sleep(100000);
//        ReentrantLock lock = new ReentrantLock();
//        lock.lock();
//        System.out.println("");

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
    public void test5(){
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        lock.unlock();
    }



    @Test
    public void test3(){
//        LocalDateTime time = LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MIN);
//        LocalDateTime localDateTime = time.plusMinutes(280);
//
//        System.out.println("时间："+localDateTime);
//        System.out.println("当天的零点:  "+ LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MIN));
        LocalDateTime localDateTime = LocalDateTime.now().withMillisOfDay(0);
        System.out.println("localDateTime:"+localDateTime.toString());
    }

    @Test
    public void test4(){
//         List<String> list1= null;
//                 new ArrayList<>();
//         list1.add("beppe1");
//         list1.add("beppe2");
//         list1.add("beppe0");
         List<String> list2=new ArrayList<>();
         list2.add("beppe3");
         list2.add("beppe4");
         list2.add("beppe5");
         list2.add("beppe6");
//        Optional<String> opt = list1.stream().filter(str -> {
//            return list2.contains(str);
//        }).findFirst();
//        boolean present = opt.isPresent();
//        System.out.println("present:"+present);
        boolean beppe3 = list2.stream().anyMatch(n -> n.equals("beppe8"));
        System.out.println("flag:"+beppe3);

    }
}
