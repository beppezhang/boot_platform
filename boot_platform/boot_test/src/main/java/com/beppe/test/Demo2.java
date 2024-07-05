package com.beppe.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.beppe.common.SnowFlake;
import com.beppe.entity.City;
import com.beppe.entity.CityDo;
import com.beppe.entity.ComponentContext;
import com.beppe.utils.JDKVersion8HashOfLong;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.handler.codec.http.cookie.Cookie;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Sets;
import org.ehcache.xml.model.TimeUnit;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.testng.annotations.Test;
import rx.functions.Action0;

import java.beans.PropertyDescriptor;
import java.sql.Connection;
import java.sql.DriverManager;
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
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

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

//            ExceptionLogger.log(e);
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
//            ExceptionLogger.log(e);
        }

        return null;
    }

    @Test
    public void test7()  {
        Set<City> list = Sets.newHashSet();
        City city = new City();
        city.setId("11");
        city.setName("beppe");
        list.add(city);
        city.setAmount(99l);
        list.add(city);
        System.out.println("size:"+list.size());
    }

    @Test
    public void test8(){
        Map<String,List<Long>> map=Maps.newHashMap();
        for (int i = 0; i < 4; i++) {
            List<Long> list = map.get("beppe");
            if(CollectionUtils.isEmpty(list)){
                List<Long> aa=Lists.newArrayList();
                aa.add(88l);
                map.put("beppe",aa);
            }else {
                list.add(99l);
            }

        }
        System.out.println("map:"+map);

    }

    @Test
    public void test9() throws InstantiationException, IllegalAccessException {
        City city = new City();
        city.setAmount(10l);
        city.setPublishTime(new Date());
        bean2Bean(city, CityDo.class);

    }

    public static <T> T bean2Bean(Object srcBeanObject, Class<T> class0) throws InstantiationException, IllegalAccessException {
        try {
            if (Objects.isNull(srcBeanObject)) {
                return class0.newInstance();
            } else {
                T t = class0.newInstance();
                if (srcBeanObject instanceof List) {
                    list2Bean((List)srcBeanObject, t, "list");
                } else {
                    bean2Bean(srcBeanObject, t);
                }

                return t;
            }
        } catch (Exception var4) {
            throw var4;
        }
    }

    public static void list2Bean(List<?> srcBeanObject, Object destBeanObject, String listPropName) {
        BeanWrapperImpl destBean = new BeanWrapperImpl(destBeanObject);
        destBean.setPropertyValue(listPropName, srcBeanObject);
    }

    public static void bean2Bean(Object srcBeanObject, Object destBeanObject) {
        BeanWrapperImpl srcBean = new BeanWrapperImpl(srcBeanObject);
        BeanWrapperImpl destBean = new BeanWrapperImpl(destBeanObject);
        PropertyDescriptor[] destDesc = destBean.getPropertyDescriptors();

        try {
            for (int i = 0; i < destDesc.length; ++i) {
                String name = destDesc[i].getName();
                if (destBean.isWritableProperty(name) && srcBean.isReadableProperty(name)) {
                    Object srcValue = srcBean.getPropertyValue(name);
                    if (srcValue != null) {
                        destBean.setPropertyValue(name, srcValue);
                    }
                }
            }

        } catch (Exception var8) {
            // TODO: 2021/7/11   明确异常信息，保证异常信息可以被上游感知到；否则难以定位问题
            String msg="BeanUtils.bean2Bean 异常错误，请检查:";
            if (var8!=null){
                msg=msg+"ExceptionClassName = "+var8.getClass().getName()+"message = "+var8.getMessage();
            }
            throw var8;
        }
    }





}
