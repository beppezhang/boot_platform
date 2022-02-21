package com.beppe.test;

import com.alibaba.fastjson.JSONObject;
import com.beppe.entity.Order;
import com.beppe.entity.OrderDTO;
import com.beppe.entity.OrderHeader;
import com.beppe.entity.OrderHeaderDTO;
import org.joda.time.LocalTime;
import org.springframework.beans.BeanUtils;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
}
