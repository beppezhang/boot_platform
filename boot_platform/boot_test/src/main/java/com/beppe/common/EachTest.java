//package com.beppe.common;
//
//import com.beppe.entity.User;
//import com.beppe.entity.UserDTO;
//import org.apache.commons.lang3.StringUtils;
//import org.joda.time.LocalDateTime;
//import org.springframework.beans.BeanUtils;
//import org.testng.annotations.Test;
//import org.testng.collections.Lists;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class EachTest {
//
//    @Test
//    public void test1() {
//        List<String> list = new ArrayList();
//        list.add("beppe1");
//        list.add("beppe2");
//        list.add("beppe3");
//        list.add("beppe4");
//        int loop;
//        list.stream().forEach(l -> {
//            boolean flag = l.equals("beppe2");
//            System.out.println("获取到的值是:" + l);
//            if (flag) {
//            }
//        });
//    }
//
//    @Test
//    public void test2() {
//        Date now = new Date();
//        LocalDateTime localDateTime = new LocalDateTime(now);
//        System.out.println("localDateTime:" + localDateTime);
//
//    }
//
//    @Test
//    public void test3() {
//
//    }
//
//    @Test
//    public void test4() {
//        List<User> list = null;
//        List<String> collect = Optional.ofNullable(list).orElse(Lists.newArrayList()).stream().map(User::getName).collect(Collectors.toList());
//        System.out.println("collect:" + collect);
//
//    }
//
//    @Test
//    public void test5() {
//        String desc = "";
//
//        String slotTypeName = getSlotTypeName(null);
//        System.out.println("履单name:" + slotTypeName);
//    }
//
//    private String getSlotTypeName(String slotType) {
//        String desc = "";
//        slotType = StringUtils.isBlank(slotType) ? "" : slotType;
//        switch (slotType) {
//            case "1":
//                desc = "配送";
//                break;
//            case "2":
//                desc = "自提";
//        }
//        return desc;
//    }
//
//    @Test
//    public void test6() {
//        Set set = new HashSet<>();
//        set.add("beppe1");
//        set.add("beppe2");
//        set.add("beppe3");
//        List<User> list = new ArrayList<>();
//        list.add(new User(1, "beppe1"));
//        list.add(new User(2, "beppe2"));
//        list.add(new User(3, "beppe2"));
//        list.add(new User(4, "beppe4"));
////        list.stream().filter(user -> user.strategies().stream()
////                .filter(strategy -> strategy.));
//
//    }
//
//    @Test
//    public void test7(){
//
//    }
//}
//
//
