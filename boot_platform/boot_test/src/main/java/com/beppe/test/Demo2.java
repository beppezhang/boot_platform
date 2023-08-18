package com.beppe.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.support.odps.udf.JSONTuple;
import com.beppe.common.SnowFlake;
import com.beppe.model.BuildItem;
import com.beppe.model.BuildItemCopy;
import com.beppe.model.ChildClass;
import com.beppe.model.OrderItem;
import com.beppe.model.UserDto;
import com.beppe.utils.JDKVersion8HashOfLong;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.annotations.JsonAdapter;
import com.yonghui.common.config.ConfigManager;
import com.yonghui.makeup.service.model.CartUpdateRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.BeanUtils;
import org.testng.annotations.Test;
import rx.functions.Action0;

import javax.com.yonghui.common.exception.log.ExceptionLogger;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Demo2 {

    @Test
    public void test1(){
        create(()->
             persist("aaa")
        );
    }

    private void create(Action0 action0){
        System.out.println("this is the create method");

    }

    private void persist(String name){
        System.out.println("this  is the persit:"+name);
    }

    @Test
    public void test3(){
//        OrderItem orderItem1= new OrderItem();
//        orderItem1.setGoodsId("001");
//        orderItem1.setOrderRemark("aaa");
//        OrderItem orderItem2= new OrderItem();
//        orderItem2.setGoodsId("002");
//        orderItem2.setOrderRemark("bbb");
//        List<OrderItem> items = Lists.newArrayList(orderItem1,orderItem2);
//        String code = getCode();
//        System.out.println("code:"+code);
        NumberFormat memberIdFormatter = NumberFormat.getNumberInstance();
        memberIdFormatter.setMinimumIntegerDigits(3);
        memberIdFormatter.setMaximumIntegerDigits(3);
        memberIdFormatter.setGroupingUsed(false);
        String memberPart =  memberIdFormatter.format(Math.abs(JDKVersion8HashOfLong.hashCodeV8(267122804542180701l)));
        System.out.println("memberPart:"+memberPart);


        NumberFormat memberIdFormatter1 = NumberFormat.getNumberInstance();
        memberIdFormatter1.setMinimumIntegerDigits(12);
        memberIdFormatter1.setMaximumIntegerDigits(12);
        memberIdFormatter1.setGroupingUsed(false);
        String pre = memberIdFormatter1.format(System.currentTimeMillis()).substring(0, 5);
        System.out.println("pre:"+pre);
        //获取redis 自增值 key ： ass:id:{120xxx}:{时间戳前5位}
//        String key = StringUtils.format(PREFIX_KEY, code, pre);


    }

    private String getCode(){
        int[] sequenceArray = {2, 6, 4, 7, 1, 8, 5, 3};
        Long id = Math.abs(new Random().nextLong());
        String serial = Long.toString(id.intValue() % 100000, 9);
        String secretCode = serial + "9" + RandomStringUtils.randomNumeric(8 - 1 - serial.length());
        //乱序
        char[] codes = secretCode.toCharArray();
        String result = "";
        for (int i : sequenceArray) {
            result += codes[i - 1];
        }
        String orderId="1209472110079233";
        result += orderId.substring(3, 6) + orderId.substring(orderId.length() - 1);
        return result;

    }

    @Test
    public void test4(){
//        String str="132603840016";
//        String s = mixSeqPart(str);
//        System.out.println("ssss:"+s);
        guaranteeSwitch("oe.release.to.shipment11","send.order.to.ofs11");


    }

    private String mixSeqPart(String seqPart) {
        int len = seqPart.length();
        String lastFive = seqPart.substring(len - 5, len);
        String pre = seqPart.substring(0,len - 5);
        char []mix=new char[len];
        char[] lastFiveChars = lastFive.toCharArray();
        char[] preChars = pre.toCharArray();
        //3 7 6 2 9
        int []dateReservePos=new int[]{2,6,5,1,8};
        int datePos=0;
        for (int dateReservePo : dateReservePos) {
            mix[dateReservePo]=lastFiveChars[datePos++];
        }
        int seqPos=0;
        for (int i=0;i<mix.length;i++){
            boolean skip=false;
            for (int dateReservePo : dateReservePos) {
                if(i==dateReservePo) skip=true;
            }
            if (skip){
                continue;
            }
            mix[i]=preChars[seqPos++];
        }
        return String.valueOf(mix);
    }

    public static boolean guaranteeSwitch(String event,String command) {
        try {
            String str = "\t{\"isopen\": 1, \"oe.release.to.shipment\":[\"send.order.to.ofs\"]}";
            if(StringUtils.isNotBlank(str)){
                Map<String, Object> map = JSON.parseObject(str, new TypeReference<Map<String, Object>>() {
                });
                if(Objects.equals(map.get("isopen"),1)){
                    List<String> list = (List<String>)map.get(event);
                    if(CollectionUtils.isNotEmpty(list)){
                        if(list.contains(command)){
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {

            ExceptionLogger.log(e);
        }
        return false;
    }

    @Test
    public void test5() throws ParseException {
        List<Map<String,String>> results = Lists.newArrayList();
        String FORMATTER_TIME="HH:mm";
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(FORMATTER_TIME);
        LocalTime startTime = dateTimeFormatter.parseLocalTime("16:00");
        LocalTime endTime = dateTimeFormatter.parseLocalTime("22:20").minusHours(1);
        while (!endTime.isBefore(startTime)){
            LocalTime oneLater = startTime.plusHours(1);
            LocalTime startTimeNext = oneLater.isBefore(startTime) ? LocalTime.parse("23:59") : oneLater;
            Map<String,String> map = Maps.newHashMap();
            map.put("start",startTime.toString(FORMATTER_TIME));
            map.put("end",startTimeNext.toString(FORMATTER_TIME));
            results.add(map);
            startTime = startTimeNext;
        }
        System.out.println("tttt:"+results);
    }

    @Test
    public void test6() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        String user = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/test";
        // 得到mysql的连接
        Connection connection = DriverManager.getConnection(url, user, password);
        // 得到可以与mysql语句进行交互的对象
        Statement statement = connection.createStatement();
        // 关闭与 mysql语句进行交互的对象
        statement.close();
        // 关闭与 mysql语句进行交互的对象
        connection.close();


    }

    public static <S, T> T copy(S object, Class<T> clazz) {
        try {
            if(Objects.isNull(object) || Objects.isNull(clazz)){
                return null;
            }
            T t = clazz.newInstance();
            BeanUtils.copyProperties(object, t);

            return t;
        } catch (Exception e) {
            System.out.println("copyexception");
            ExceptionLogger.log(e);
        }

        return null;
    }

    @Test
    public void test7() throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:/test");
        Class clazz = myClassLoader.loadClass("com.beppe.model.ClassLoaderModel");
        Object obj = (Object) clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sout", null);
        method.invoke(obj,null);

    }

    @Test
    public void test8(){
        List<String> ids=Lists.newArrayList("aa","bb","cc");
        List<String> allList=Lists.newArrayList("aa","dd","bb");
        for (String aa:allList){
            if(!ids.contains(aa)){
                continue;
            }
            System.out.println("ids:"+aa);
        }

    }

    @Test
    public void test9(){
        SnowFlake snowFlake = new SnowFlake(2, 3);

        for (int i = 0; i < 20; i++) {
            System.out.println(snowFlake.nextId());
        }
    }






}
