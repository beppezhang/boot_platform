package com.beppe.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.beppe.model.OrderItem;
import com.beppe.utils.JDKVersion8HashOfLong;
import com.google.common.collect.Lists;
import com.google.gson.annotations.JsonAdapter;
import com.yonghui.common.config.ConfigManager;
import com.yonghui.makeup.service.model.CartUpdateRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;
import rx.functions.Action0;

import javax.com.yonghui.common.exception.log.ExceptionLogger;
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
        String s= "2023-04-23 11:32:15";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(s);
        System.out.println("parse:"+parse);

    }




}
