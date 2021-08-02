package com.beppe.test;

import com.beppe.common.EventConstant;
import com.beppe.common.OrderStatus;
import com.beppe.entity.Strategy;
import com.beppe.entity.User;
import com.beppe.entity.UserDTO;
import com.beppe.processor.CentralControl;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaTest {

    /**
     * 从list中找到匹配的对象
     * CREATE --user1 CANCEL-- user1  user2   payok  --user2
     */
    @Test
    public void test1() {
//        String event = EventConstant.PAYOK;
//        List<Strategy> strategyList = new ArrayList<>();
//        strategyList.add(new User1());
//        strategyList.add(new User2());
//        List<Strategy> collect = strategyList.stream().filter(user -> isMatch(user, event)).collect(Collectors.toList());
//        for (Strategy s:collect){
//            System.out.println("name:"+s.getName());
//        }
        CentralControl centralControl = new CentralControl();
        centralControl.doProcess(EventConstant.REFUND);

    }

    private boolean isMatch(Strategy user, String event) {
        if (user.getStrategy().contains(event)) {
            return true;
        }
        return false;
    }

    @Test
    public void test2() {
        List<UserDTO> list = new ArrayList<>();
        list.add(UserDTO.builder().name("beppe1").build());
        list.add(UserDTO.builder().name("beppe2").build());
        list.add(UserDTO.builder().name("beppe3").build());
        boolean flag = list.stream().anyMatch(p -> p.getName().equals("beppe2"));
        System.out.println("flag===" + flag);
    }

    @Test
    public void test3() {
        Map map = new HashMap<String, Object>();
        List<String> list = new ArrayList<>();
        list.add("oiiid");
        map.put("name", list);
        List<String> name = (List<String>) map.get("name");
        System.out.println("name:" + name);
    }

    @Test
    public void test4() {
        LocalTime localTime = new LocalTime(16, 3);
//        System.out.println("localTime:" + localTime);
        LocalDateTime dateTime = LocalDateTime.fromDateFields(new Date());
        System.out.println("dateTime:" + dateTime.toDate());
        int i = dateTime.toLocalTime().compareTo(localTime);
//        System.out.println("iiiii:" + i);
    }

    @Test
    public void test5() {
        String orderMessType = getOrderMessType("os.in.progress33");
        System.out.println("orderMessType:" + orderMessType);
    }

    public static String getOrderMessType(String status) {
        String messType = "";
        try {
            OrderStatus orderStatus = OrderStatus.getOrderStatus(status);
            switch (orderStatus) {
                case IN_PROGRESS:
                    messType = "pay.ok";
                    break;
                case CANCELLED:
                    messType = "cancel";
                    break;
                case REFUNDED_COMPLETED:
                    messType = "refunded";
                    break;
                default:
                    messType = "";
            }
        } catch (Exception e) {
//            messType="";
        }
        return messType;
    }

    @Test
    public void test6() {
        List<UserDTO> list = new ArrayList<>();
        List<String> collect = list.stream().filter(userDTO -> userDTO.getName() == "beppe").map(UserDTO::getName).collect(Collectors.toList());
        System.out.println("collet:" + collect);
    }

    @Test
    public void test7() {
        List<UserDTO> list = new ArrayList<>();
        list.add(UserDTO.builder().id(1).build());
        list.add(UserDTO.builder().id(2).build());
        list.add(UserDTO.builder().id(3).build());
        list.forEach(userDTO -> userDTO.setName("beppe"));

        list.forEach(userDTO -> System.out.println(userDTO.getName()));
    }

    @Test
    public void test8() {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"beppe1"));
        list.add(new User(2,"beppe2"));
        UserDTO build = UserDTO.builder().users(list).build();
        build.getUsers().forEach(user -> user.getName().equals("beppe1"));

    }

}
