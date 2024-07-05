package com.beppe.test;


import com.alibaba.fastjson.JSON;
import com.beppe.entity.Order;
import com.beppe.entity.OrderDTO;
import com.beppe.model.UserDto;
import com.beppe.utils.DateUtils;
import com.google.common.collect.Lists;
import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;
import org.springframework.cglib.beans.BeanCopier;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Demo1 {

    //    @Test
//    public void test1(){
//        // 栈
//        Stack<String> stack= new Stack();
//        stack.push("beppe1");
//        stack.push("beppe2");
//        stack.push("beppe3");
//        String peek = stack.pop();
//        System.out.println("peek:"+peek);
//
//        // 队列
//        Deque<String> queue=new LinkedList();
//        queue.push("beppe1");
//        queue.push("beppe2");
//        queue.push("beppe3");
//        String poll = queue.pop();
//        System.out.println("poll:"+poll);
//    }
//
////    @Test
//    public void test2(){
//        System.out.println("111");
//    }
//    public static void main(String[] args) {
////        List<Order> list = Lists.newArrayList();
////        Order order1 = new Order();
////
////        Order order2 = new Order();
////        Order order3 = new Order();
////        order1.setId(0010);
////        order1.setParentId(01);
////        order2.setId(0020);
////        order2.setParentId(02);
////        order3.setId(0030);
////        order3.setParentId(02);
////        list.add(order1);
////        list.add(order2);
////        list.add(order3);
////        Map<String, String> map = Maps.newHashMap();
////        ImmutableMap<Integer, Order> integerOrderImmutableMap = Maps.uniqueIndex(list, item -> item.getParentId());
//        List<Integer> integers = Lists.newArrayList(2, 8);
//        boolean b = Optional.ofNullable(integers).orElse(Lists.newArrayList()).stream().anyMatch(
//                p -> (p & 9) > 0);
////        int i = 9 & 8;
//        System.out.println("b:"+b  );
//
//
//
//    }

    @Test
    public void test1() {
        List<Order> list = Lists.newArrayList();
//        Order order1 = new Order();
//
//        Order order2 = new Order();
//        order1.setId(0010);
//        order1.setName("beppe2");
//        order1.setParentId(01);
//        order1.setHeaders(Lists.newArrayList());
//        order2.setId(0020);
//        order2.setParentId(02);
//        order2.setName("beppe2");
//        order2.setHeaders(Lists.newArrayList(new OrderHeader()));
//        list.add(order1);
//        list.add(order2);

//        boolean b = list.stream().allMatch(order -> {
//            return CollectionUtils.isNotEmpty(order.getHeaders());
//        });
//        System.out.println("bbe:"+b);
        List<Order> beppe2 = list.stream().filter(order -> order.getName().equals("beppe2")).collect(Collectors.toList());
        boolean flag = beppe2.stream().anyMatch(order -> order.getName().equals("beppe2"));
        System.out.println("flag:" + flag);


    }

    @Test
    public void test2() {
//        String jsonString="{\"data\":1653455330583,\"channel\":\"yhlife_ios\",\"type\":\"log in\",\"deviceId\":\"B3D44A7A-CE07-4923-8139-3290FA2FA11A\",\"memberId\":944857465536676208}";
//        MemberModel memberModel = JSON.parseObject(jsonString, MemberModel.class);
//        System.out.println("meme:"+memberModel.getChannel());
//        int a=0;
//        for (int i = 0; i <3 ; i++) {
//            a+=3;
//        }
//        System.out.println("aaaa:"+a);
//        Integer a=1;
//        int b=1;
//        boolean equals = Objects.equals(a, b);
//        System.out.println("equals:"+equals);
        Order order = new Order();
        order.setId(111);
        order.setName("beppe1");
//        ComponentContext context = ComponentContext.builder().id(11110000l).name("zhangsl").
//                result(order).build();
//        Order result = (Order) context.getResult();
//        System.out.println("name:" + result.getName());

    }

    @Test
    public void test3() {
        List<Pair<String, String>> pairList = Lists.newArrayList();
        pairList.add(new Pair<>("name", "beppe"));
        pairList.add(new Pair<>("city", "shhhh"));
        Order order = new Order();
        order.setPairs(pairList);
        System.out.println("bbbb:"+order.getPairs());
        String s = JSON.toJSONString(order);
        System.out.println("序列化：" + s);
        Order oo = JSON.parseObject(s, Order.class);
        System.out.println("反序列化："+oo.getName());

    }

    @Test
    public void test4(){
//        String aa="N(yhshop)";
//        System.out.println("aa:"+aa.length());
//        char c = aa.charAt(0);
////        System.out.println("flag:"+c);
//        boolean equals = 'N'==c;
//        System.out.println("isEquals:"+equals);
//        String trim = aa.trim();
//        System.out.println("trim:"+trim);
//        String substring = aa.substring(2, aa.length()-1);
//        System.out.println("substring:"+substring);
//        Order order = new Order();
//        System.out.println("name:"+order.getClass().getName());

        //
//        Collection<String> values=Lists.newArrayList("不杀","切","一一一一一一一一一一一一");
//        List<String> strings = Lists.newArrayList("不杀", "切");
//        boolean b = values.containsAll(strings);
//        System.out.println("bbb:"+b);
        int num=10;
        List<Integer> aa = Lists.newArrayList();
        List<Integer> integers = Lists.newArrayList(12, 4, 3,5);
        int tatol=0;
        int index=0;
        for (int i = 0; i < integers.size(); i++) {

            if((tatol+integers.get(i))<num){
                aa.add(integers.get(i));
            }else {
                break;
            }
            tatol+=integers.get(i);
            index++;
        }

//        aa.add(num-tatol);

        System.out.println("new:"+(num-tatol)+"i:"+index);
    }

    @Test
    public void test5(){
//        OrderUpdateInfo.OrderItemInfo build = OrderUpdateInfo.OrderItemInfo.builder().logisticNo(Lists.newArrayList("111"))
//                .origLogisticNo(Lists.newArrayList("2222")).orderItemId(3333l).build();
//        OrderUpdateInfo orderUpdateInfo = OrderUpdateInfo.builder().operator("aaa").orderId(1009l).orderItemInfo(Lists.newArrayList(build)).updateReason("aaa").updateType(1).build();
//        OrderUpdateInfo orderUpdateInfo1 = JSON.parseObject(JSON.toJSONString(orderUpdateInfo), new TypeReference<OrderUpdateInfo>() {
//        });
//        System.out.println(orderUpdateInfo1.getOperator());
//        String str="N(2222,456)";
//        List<String> strings = Lists.newArrayList(str.substring(2, str.length()-1));
//        boolean contains = strings.contains("1233");
//        System.out.println("length:"+contains);
//        Pair pair=new Pair<String,String>("12：00","14:00");
//        System.out.println("k:"+pair.getKey());
//        System.out.println("v:"+pair.getValue());
        Map<String, Order> map = new HashMap<>();
        Order order1 = new Order();
        Order order2 = new Order();
        order1.setId(11);
        order1.setName("beppe1");
        order2.setId(22);
        order2.setName("beppe2");
        map.put("name1",order1);
        map.put("name2",order2);
        Map<String, OrderDTO> collect = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setName(entry.getValue().getName());
            orderDTO.setId(entry.getValue().getId());
            return orderDTO;
        }, (a1, a2) -> a1));
        System.out.println("map:"+ JSON.toJSONString(collect));
    }

    @Test
    public void test6(){
//        Integer i=2;
//        boolean b = (i & 1) > 0;
//        System.out.println("vvv:"+b);
//        LocalTime fromTime = LocalTime.now().plusMinutes(20);
//        LocalTime toTime = fromTime.plusMinutes(20);
//        System.out.println(fromTime+":"+toTime);
//        LocalTime localTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
//        System.out.println("localTime:"+localTime);
//        LocalTime now = LocalTime.now();
//        LocalTime plusTime=now;
//        System.out.println();
        String payat="2022-07-14 14:26:34";
        Date date = DateUtils.getDate(payat, DateUtils.DEFAULT_TIME_FORMAT_STRING);
        Date date1 = calDeliveryDate(false, null, date, null);
        System.out.println("date1:"+date1);
    }


    public static Date calDeliveryDate(boolean isCenterWarehouse, String deliveryEnd, Date payDate, Date expectedDeliveryDate) {
        LocalDateTime orderAt = (new LocalDateTime(payDate)).plusDays(1);
        if (expectedDeliveryDate != null) {
            orderAt = new LocalDateTime(expectedDeliveryDate);
        }

        if (isCenterWarehouse) {
            try {
                org.joda.time.LocalTime deliveryEndTime = new org.joda.time.LocalTime(deliveryEnd);
                if (orderAt.toLocalTime().isAfter(deliveryEndTime)) {
                    orderAt = orderAt.plusDays(1);
                }
            } catch (Exception var6) {
                orderAt = orderAt.plusDays(1);
            }
        }

        return orderAt.toLocalDate().toDate();
    }

    @Test
    public void test7(){
//        LocalTime now = LocalTime.now();
//        LocalTime plusTime = now.plusMinutes(30);
//
//        System.out.println("now:"+now.isBefore(now));
//        int i=14;
//        int a = i & 1;
//        System.out.println("aa:"+a);
//        LocalTime parse = LocalTime.parse("23:40");
//        LocalTime localTime = parse.plusMinutes(40).isBefore(parse) ? LocalTime.parse("23:59") : parse.plusMinutes(40);
//        System.out.println("localTime:"+localTime);
//
//        List<String> strings = Lists.newArrayList("111", "222");
//        boolean contains = strings.contains("");
//        System.out.println("contains:"+contains);
        List<String> remarks = Lists.newArrayList();
        boolean contains = remarks.contains("22");
        System.out.println("contains:"+contains);
    }

    @Test
    public void test8(){
//        BigDecimal divide = divide(multiply(new BigDecimal(0.4), new BigDecimal(0.11)), new BigDecimal(8.22));
//        System.out.println("divide:"+divide);
//        String operationDesc="销售异常改单;序号:1,商品编码:B-810389,改前标价:1.00,改后标价:0.50,改前售价:1.00,改后售价:0.50,改前数量:2.0000,改后数量:4.0000;序号:2,商品编码:B-641828,改前标价:1.00,改后标价:2.00,改前售价:1.00,改后售价:2.00,改前数量:2.0000,改后数量:1.0000;序号:3,商品编码:B-810018,改前标价:0.70,改后标价:0.45,改前售价:0.70,改后售价:0.45,改前数量:2.0000,改后数量:3.1230";
//        operationDesc=operationDesc.length()>240?operationDesc.substring(0,240):operationDesc;
//        System.out.println("sub:"+operationDesc);

        List<Integer> list = Lists.newArrayList(5, 7, 9);
        for (int i = 0; i < list.size(); i++) {

        }

    }

    public static BigDecimal divide(BigDecimal first, BigDecimal second) {

            return first.divide(second, 2, 4);

    }

    public static BigDecimal multiply(BigDecimal first, BigDecimal second) {
            return first.multiply(second).setScale(2, 4);

    }

    @Test
    public void test9() throws InterruptedException {

        UserDto userDto1 = new UserDto();
        userDto1.setName("beppe");
        userDto1.setAge(12);
        UserDto userDto2 = new UserDto();
        userDto2.setName("beppe1");
        userDto2.setAge(14);
        UserDto userDto3 = new UserDto();
        userDto3.setName("beppe3");
        userDto3.setAge(16);
//        List<UserDto> userDtoList=Lists.newArrayList();
        List<UserDto> userDtoList = Lists.newArrayList(userDto1,userDto2,userDto3);
////        List<UserDto> userDtoList=Lists.newLinkedList();
////        Map<String, UserDto> map = userDtoList.stream().collect(Collectors.toMap(UserDto::getName, Function.identity()));
////        String s = Objects.isNull(map.get("beppe3")) ? "" : map.get("beppe3").getName();
////        System.out.println("sss:"+s);
//        List<UserDto> collect = userDtoList.stream().map(userDto -> {
//            UserDto userDto4 = new UserDto();
//            userDto4.setName(userDto.getName());
//            userDto4.setAge(userDto.getAge());
//            return userDto4;
//        }).collect(Collectors.toList());
//        List<String> str = Lists.newArrayList("aa", "bb");
//        List<String> str1=Lists.newArrayList();
//        baseConvert(str,List.class);
//        Map<Long, String> map = new HashMap<>();
//        map.put(123L,"beppe");
//        String s = map.get(null);
//        System.out.println("sss:"+s);
//        Map<String, UserDto> map = Optional.ofNullable(userDtoList).orElse(Lists.newArrayList()).stream()
//                .collect(Collectors.toMap(UserDto::getName, Function.identity(), (key1, key2) -> key2));
//        if(Objects.nonNull(map.get("beppe"))){
//            UserDto userDto = map.get("beppe");
//            System.out.println("结果是："+userDto.getAge());
//        }
        for (UserDto dto:userDtoList){
            if(StringUtils.equals(dto.getName(),"beppe")){
                continue;
            }
            System.out.println("aaa:"+dto.getName());
        }


    }
    @Test
    public void test10(){
        LocalDateTime plusHours = LocalDateTime.now().plusHours(18);
        LocalDateTime localTime = LocalDateTime.now().withHourOfDay(22).withMinuteOfHour(30);
        System.out.println(plusHours.isBefore(localTime));
    }

    public final static  <T, R> T  baseConvert(R resourceObj,   Class<T> targetClazz){
        if ( resourceObj==null){
            return null;
        }
        BeanCopier beanCopier = BeanCopier.create(resourceObj.getClass(), targetClazz, false);
        T targetObject=null;
        try {
            targetObject = targetClazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if(targetObject==null){
            throw new RuntimeException(MessageFormat.format("构造{0}失败，BeanCopier无法完成",targetClazz));
        }
        beanCopier.copy(resourceObj,targetObject,null);
        return targetObject;
    }

    @Test
    public void test11(){
//        String format = String.format("%s,%s-%s", "2022-11-13", "20:00", "20:30");
//        String IMMEDIATE_DESCRIPTION_DEL="立即配送,预计%s送达";
//        String format = String.format(IMMEDIATE_DESCRIPTION_DEL, "20:30");
//        System.out.println("format:"+format);
        LocalDateTime day1 = new LocalDateTime("2022-11-24");
        LocalDateTime day2 = new LocalDateTime("2022-11-25");
        Date date1 = day1.toDate();
        Date date2 = day2.toDate();
       List<Date> list = Lists.newArrayList();
        list.add(date2);
        list.add(date1);
        System.out.println("list11:"+list);
        list.sort(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("list:"+list);


    }

    @Test
    public void test12(){
        List<UserDto> list = Lists.newArrayList();
        UserDto userDto1 = new UserDto();
        userDto1.setName("beppe1");
        userDto1.setAge(12);
        UserDto userDto2 = new UserDto();
        userDto2.setName("beppe2");
        userDto2.setAge(null);
        list.add(userDto1);
        list.add(userDto2);
        Optional<UserDto> first = Optional.ofNullable(list).orElse(Lists.newArrayList()).stream()
                .filter(userDto -> {
                    return StringUtils.equals("beppe3",userDto.getName());
                }).findFirst();
        boolean present = first.isPresent();
        System.out.println("present:"+present);
    }

    @Test
    public void test13() throws InterruptedException {
//        StopWatch stopWatch = new StopWatch("test13");
//        stopWatch.start();
//        System.out.println("this is  test");
//        Thread.sleep(100);
//        stopWatch.stop();
//        System.out.println("time:"+stopWatch.getLastTaskTimeMillis());
//        stopWatch.start();
//        Thread.sleep(50);
//        stopWatch.stop();
//        System.out.println("time111:"+stopWatch.getLastTaskTimeMillis());
//        System.out.println("aaa");
//        int i = 10 & 4;
//        System.out.println("iii:"+i);
        List<String> strings = Lists.newArrayList("aa", "bb", "cc");
        for(String str:strings){
            if(str.equals("bb")){
                continue;
            }
            System.out.println("str:"+str);
        }
//        strings.stream().peek(str->{})


    }

    @Test
    public void test14(){
        Order order1 = new Order();
        order1.setName("aa");
        Order order2 = new Order();
        order2.setName("bb");
        order2.setAmout(new BigDecimal(2.0));
        Order order3 = new Order();
        order3.setAmout(new BigDecimal(2.0));
        List<Order> list = Lists.newArrayList(order1, order2, order3);
//        List<Order> list1 = Lists.newArrayList(order1, order2);
////        list.removeAll(list1);
//        boolean bb = list.stream().anyMatch(order -> order.getName().equals("dd"));
//        System.out.println("bb:"+bb);
        BigDecimal reduce = list.stream()
                .map(item->{
                    return Objects.isNull(item.getAmout())?BigDecimal.ZERO:item.getAmout();
                }).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("aaa:"+reduce);
    }

    @Test
    public void test15(){
        // id  列表
        Order order1 = new Order();
        order1.setName("aa");
        Order order2 = new Order();
        order2.setName("bb");
        order2.setAmout(new BigDecimal(2.0));
        Order order3 = new Order();
        order3.setName("aa");
        order3.setAmout(new BigDecimal(2.0));
        Order order4 = new Order();
        order4.setName("aa");
        order4.setAmout(new BigDecimal(2.0));
        List<Order> list1 = Lists.newArrayList(order1,order2,order3,order4);

    }

    @Test
    public void test16(){
        Map<String, BigDecimal> map = com.google.common.collect.Maps.newHashMap();
        map.put("111",new BigDecimal(2));
        map.put("222",new BigDecimal(4));
        for (Map.Entry<String, BigDecimal> enty:map.entrySet()){
            if ("222".equals(enty.getKey())){
//                BigDecimal substract = MoneyUtils.substract(enty.getValue(), BigDecimal.ONE);
//                enty.setValue(substract);
            }
        }
        System.out.println("aaa");
    }

    @Test
    public void test17(){
        List<String> list = Lists.newArrayList("333","444");
        List<String> list2 = Lists.newArrayList();
        list.addAll(list2);
        System.out.println("list"+list);

    }

    private String reduceRemarkNum(Map<String, Integer> countMap, Integer qty) {
        Iterator<Map.Entry<String, Integer>> iterator = countMap.entrySet().iterator();
        String newRemark="";
        while (iterator.hasNext()) {
            if(qty<=0){
                break;
            }
            Map.Entry<String, Integer> next = iterator.next();
            Integer remarkCount = next.getValue();
            if (qty >= remarkCount) {
                // 商品001   数量 3    备注A 2  备注B 2    (备注A 2   备注B 1  备注数量不变)
                qty=qty-remarkCount;
                newRemark = newRemark+next.getKey()+"X"+remarkCount+"；";
                iterator.remove();
            } else {
                // 备注数量减
                Integer remarkCountLeft=remarkCount-qty;
                countMap.put(next.getKey(),remarkCountLeft);
                newRemark= newRemark+next.getKey()+"X"+qty+"；";
                qty=0;
            }
        }
        return newRemark;
    }



}
