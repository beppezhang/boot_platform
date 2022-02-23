package com.beppe.test;

import com.beppe.entity.Order1;
import com.beppe.entity.Order2;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class AATest {

    ThreadPoolExecutor pool=new ThreadPoolExecutor(5,10,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
    @Test
    public void test1(){
        System.out.println(2|4);
        int i = 6;
        int i1 = i & 1024;
        System.out.println("il:"+i1);
    }
//
//
    @Test
    public void test2(){
        // 与运算I
        Integer i=null;
        Integer i1 = i==null ? null:i&2;
        System.out.println("flag:"+i1);
    }

    @Test
    public void test3(){
        Order1 aa1 = new Order1(1l, "aa");
        Order1 aa2 = new Order1(2l, "bb");
        Order1 aa3 = new Order1(3l, "cc");
        List<Order1> order1s = new ArrayList<>();
        order1s.add(aa1);
        order1s.add(aa2);
        order1s.add(aa3);
        Order2 order2 = new Order2();
        order2.setList(order1s);
        List<FutureTask<String>> result =new ArrayList<>();
        long start = System.currentTimeMillis();
        List<Order1> os = new ArrayList<>();
        for (Order1 o:order2.getList()){
            FutureTask<String> future1 = new FutureTask<>(new Runnable() {

                @Override
                public void run() {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    if(o.getId()==2l){
                        return;
                    }
                    o.setCode("jjjj");
                    os.add(o);
                    System.out.println("打印：" + o.getCode());
                }
            }, "finished");
            result.add(future1);
            pool.submit(future1);

        }

        for (FutureTask<String> res:result){
            try {
                String s = res.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
        for (Order1 i:os) {
            System.out.println("iiiii:"+i.getCode());
        }

        // 拿到结果
        System.out.println("执行时间："+(System.currentTimeMillis()-start));
    }

    @Test
    public void test4(){
        // 数组
        List list=new ArrayList<>();
        // 链表
        List<Object> list2 = new LinkedList<>();
        list2.add(111);
        Stack<Object> stack = new Stack<>();
        stack.add(111);

        Set<Object> set1 = new HashSet<>();
        set1.add(111);
        LinkedHashSet<Object> set2 = new LinkedHashSet<>();
        set2.add(22);
        TreeSet<Object> set3 = new TreeSet<>();
        set3.add(333);

        // =========== 线程安全
        Vector<Object> vector = new Vector<>();
        vector.add("aaa");
        vector.get(1);

        List<Object> list3 = new CopyOnWriteArrayList<>();
        list3.add("aa");
        list3.get(0);

        List<Object> list4 = Collections.synchronizedList(new ArrayList<>());
        list4.add("nnn");

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("aaa","beppe1");
        Map<Object, Object> map1 = new HashMap<>();
        map1.put("bbb","beppe2");

        Map map3=new ConcurrentHashMap<>();
        map3.put("name","beppe1");
        map3.get("name");
    }

    @Test
    public void test5(){
        // jdk 锁
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
    }
}
