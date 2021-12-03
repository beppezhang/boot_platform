package com.beppe.test;

import com.beppe.common.EventConstant;
import com.beppe.common.OrderStatus;
import com.beppe.entity.Order1;
import com.beppe.entity.Order2;
import com.beppe.entity.Strategy;
import com.beppe.entity.User;
import com.beppe.entity.UserDTO;
import com.beppe.processor.CentralControl;
import com.beppe.utils.CartUtil;
import com.google.common.collect.Lists;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

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
        list.add(UserDTO.builder().id(1).name("beppe1").build());
        list.add(UserDTO.builder().id(2).name("beppe2").build());
        list.add(UserDTO.builder().id(2).name("beppe3").build());
//        boolean flag = list.stream().anyMatch(p -> p.getName().equals("beppe2"));
//        System.out.println("flag===" + flag);
        Map<Integer, String> collect = list.stream().collect(Collectors.toMap(UserDTO::getId, UserDTO::getName,(k1, k2)->k2));
        System.out.println("collect:"+collect);
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
        list.add(UserDTO.builder().id(1).name("beppe1").build());
        list.add(UserDTO.builder().id(1).name("beppe2").build());
        list.add(UserDTO.builder().id(3).name("beppe3").build());
//        Map<Integer, List<User>> maps = list.stream().map(userDTO -> {
//            User user = new User(userDTO.getId(), userDTO.getName());
//            return user;
//        }).collect(groupingBy(User::getId));
//        List<User> collect = maps.values().stream().map(value -> {
//            User user = value.get(0);
//            Map map=new HashMap<Integer,String>();
//            value.stream().flatMap(p->p.)
//        }).collect(Collectors.toList());
//        System.out.println("collect:"+collect);
//        list.stream().flatMap()
    }

    @Test
    public void test8() {


    }

    @Test
    public void test9() {
        int i = 3;
        List<User> list = new ArrayList<>();
//        list.add(new User(1, "beppe1", true));
//        list.add(new User(2, "beppe2", true));
//        list.add(new User(3, "beppe3", false));
        StringBuilder sb = new StringBuilder();
//        list.forEach(user -> {
//            sb.append(user.getName());
//            if(sb.length()!=list.size()){
//                sb.append(",");
//            }
//
//        });
//        int i1 = sb.toString().lastIndexOf(",");
        String substring = sb.toString().substring(0, sb.toString().length() - 1);
        System.out.println("substring" + substring);
//        System.out.println("cccc"+collect);

    }

    @Test
    public void test10() {
        Map<String, UserDTO> map = new HashMap<>();
        map.put("user", UserDTO.builder().id(11).name("BEPPE").build());
        UserDTO user = map.get("user");
        user.setName("beppe1");
        System.out.println(user);


    }

    @Test
    public void test11() {
        User user = new User(11, "beppe");
        List<Order2> or2 = CartUtil.buildMultiCartInfo(user, order1 -> buildOrder2(user, order1));

    }

    private Order2 buildOrder2(User user, Order1 order1) {
        System.out.println("doing order2");
        Order2 order2 = new Order2();
        order2.setCode(user.getName());
        return order2;
    }

    @Test
    public void test12() {
        Order1 o1=new Order1(1l,"aa");
        Order1 o2=new Order1(2l,"bb");
        Order1 o3=new Order1(3l,"cc");
        Order1 o4=new Order1(4l,"dd");
        Order1 o5=new Order1(5l,"ee");
        List<Order1> l1 = Lists.newArrayList(o1, o2);
        List<Order1> l2 = Lists.newArrayList(o3, o4);
        List<Order1> l3 = Lists.newArrayList(o5);
        User user1 = new User(11, "beppe");
        User user2 = new User(21, "beppe");
        User user3 = new User(21, "beppe2");
        User user4 = new User(21, "beppe4");
        user1.setOrders(l1);
        user2.setOrders(l2);
        user3.setOrders(l3);
        List<User> users = Lists.newArrayList(user1, user2, user3, user4);
//        Map<Integer, List<String>> collect = users.stream().collect(Collectors.groupingBy(User::getId, Collectors.mapping(User::getName, Collectors.toList())));
//        System.out.println("map====" + collect);
//        List<String> collect = users.stream().filter(p-> CollectionUtils.isNotEmpty(p.getOrders())).flatMap(p -> p.getOrders().stream()).map(Order1::getCode).collect(Collectors.toList());
//        System.out.println("collect:"+collect);
//        boolean flag = users.stream().anyMatch(p -> p.getName().contains("beppe5"));
//        System.out.println("包含标识："+flag);
        users.stream().peek(p->{
            System.out.println("peek:"+p.getName());
        });
    }


}
