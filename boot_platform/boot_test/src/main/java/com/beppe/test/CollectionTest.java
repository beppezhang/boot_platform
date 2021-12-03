package com.beppe.test;

import org.joda.time.LocalDateTime;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CollectionTest {

    @Test
    public void test1(){
        List<String> list=new ArrayList();
        list.add("beppe1");
        list.add("beppe2");
        list.add("beppe3");
        System.out.println("list:"+list);
        list.add(0,"beppe4");
        System.out.println("after:"+list);
    }

    @Test
    public void test2(){
        Function<String, Long> aggregateFunction = name->getNum(name);
        Long num = aggregateFunction.apply("beppe");
        System.out.println("num:"+num);
    }

    private Long getNum(String name){
        System.out.println("name"+name);
        return 100l;
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
