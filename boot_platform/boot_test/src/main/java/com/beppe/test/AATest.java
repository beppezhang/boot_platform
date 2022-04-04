package com.beppe.test;

import com.alibaba.fastjson.JSONObject;
import com.beppe.entity.Order;
import com.beppe.entity.OrderDTO;
import com.beppe.entity.OrderHeader;
import com.beppe.entity.OrderHeaderDTO;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.beans.BeanUtils;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AATest {

    ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,100, TimeUnit.SECONDS,new LinkedBlockingDeque<>());


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
        String user=null;
        String str="beppe";
        String name=null;
        System.out.println(user+":"+str+":"+name);
    }

    @Test
    public void test4(){

        LocalTime localDateTime = LocalTime.now().withHourOfDay(14).withMinuteOfHour(30);
        LocalTime localDateTime1 = LocalTime.now().withHourOfDay(14).withMinuteOfHour(30);
        boolean after = localDateTime.isAfter(localDateTime1);
        System.out.println("after:"+after);
    }

    @Test
    public void test5(){
//        List<String> lists = null;
//        lists.forEach(str-> System.out.println("str:"+str));
        LocalTime start = LocalTime.now().withHourOfDay(23).withMinuteOfHour(30);
        LocalTime nextTime = start.plusMinutes(60);
        System.out.println("start:"+start);

    }

    @Test
    public void test7(){
        int i=9;
        try {
            i=4;
            int b=0/5;
        }catch (Exception e){

        }
        System.out.println("i 的值："+i);

    }


    @Test
    public void test8() throws ClassNotFoundException {
        String s1="hello";
        String s3="hel"+"lo";

        System.out.println(s1==s3);

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        systemClassLoader.loadClass("com.beppe.test.Alothg");
    }



    @Test
    public void test10() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务");
            }
        });
    }

    @Test
    public void test11() throws InvocationTargetException, IllegalAccessException {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setId(123);
        orderHeader.setCode("aaa");
        orderHeader.setAmt(new BigDecimal(2.00));
        orderHeader.setCreateTime(new Date());
        orderHeader.setStatus(null);
        Order order = new Order();
        order.setHeader(orderHeader);
        OrderHeaderDTO orderHeaderDTO = new OrderHeaderDTO();
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order,orderDTO);
        System.out.println("orderDTO"+ JSONObject.toJSONString(orderDTO));
      }


     @Test
    public void test12(){
         Queue<Integer> queue = new LinkedList<>();
         queue.offer(1);
         queue.offer(2);
         queue.offer(3);
         System.out.println("出队列的数据:"+queue.poll());
         System.out.println("queue"+queue);
     }

     @Test
    public void test13(){
        List<Order> list=new ArrayList<>();
         Order order1 = new Order();
         order1.setId(111);
         order1.setName("beppe1");
         Order order2 = new Order();
         order2.setId(222);
         order2.setName("beppe1");
         Order order3 = new Order();
         order3.setId(333);
         order3.setName("beppe3");
         list.add(order1);
         list.add(order2);
         list.add(order3);
         Map<Integer, List<Order>> collect = list.stream().collect(Collectors.groupingBy(Order::getId));
         System.out.println("collect:"+JSONObject.toJSONString(collect));
//         Map<String, List<Order>> collect = list.stream().filter(order -> StringUtils.isNotBlank(order.getName())).collect(Collectors.groupingBy(Order::getName));
//         System.out.println("collect:"+collect.containsKey("beppe"));
//         Order order = collect.get(222);
//         order.setName("shangliang");
//         System.out.println("collect:"+list);

//         Order order1 = new Order();
//         order1.setId(111);
//         order1.setName("beppe1");
//         Order order2=order1;
//         order1.setName("shangliang");
//         System.out.println("order2:"+order2.getName());

     }

     @Test
    public void test14(){
         NumberFormat getSubIdFormatterWith3Suffix = NumberFormat.getNumberInstance();
         getSubIdFormatterWith3Suffix.setMinimumIntegerDigits(3);
         getSubIdFormatterWith3Suffix.setMaximumIntegerDigits(3);
         getSubIdFormatterWith3Suffix.setGroupingUsed(false);

         Order order1 = new Order();
         order1.setId(111);
         order1.setName("beppe1");
         List<Order> list = new ArrayList<>();
         list.add(order1);
         int index =list.size();
//         for (Order item : list) {
             String itemString = "1000" + getSubIdFormatterWith3Suffix.format(index++);
//             item.setId(Integer.parseInt(itemString));
//             item.setOrderId(id);
//             if (item.getRowNum() == null)
//                 item.setRowNum(index-2);
//         }
     }

     @Test
    public void test15(){
        long a1=1205651300021040001l;
        long a2=1205651300021040001l;
        System.out.println("result:"+ Objects.equals(a1,a2));
     }

     @Test
    public void test16(){
         Order order1 = new Order();
         order1.setId(111);
         order1.setName("beppe1");
         Order order2 = new Order();
         order2.setId(111);
         order2.setName("beppe2");
         Order order3 = new Order();
         order3.setId(333);
         order3.setName("beppe3");
         List<Order> list = new ArrayList<>();
         List<Integer> list1 = new ArrayList<>();
         list.add(order1);
         list.add(order2);
         list.add(order3);
         Map<Integer, List<Order>> collect = list.stream().collect(Collectors.groupingBy(Order::getId));


         System.out.println("list1:"+JSONObject.toJSONString(collect));
    }


    @Test
    public void test17(){
        Order order1 = new Order();
        order1.setId(111);
        order1.setName("beppe1");
        List<Order> orders = Lists.newArrayList(order1);
        order1=new Order();
        order1.setId(222);
        order1.setName("beppe3");
        List<Order> orders2 = Lists.newArrayList(order1);
    }
}
