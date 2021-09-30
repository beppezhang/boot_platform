package com.beppe.test;

import com.beppe.entity.User;
import com.beppe.utils.DateUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DateTest {

    @Test
    public void test1(){
//        Date date1 = DateUtils.getDate("2021-07-21 10:00:00", DateUtils.DEFAULT_TIME_FORMAT_STRING);
        Date date2 = DateUtils.getDate("2021-07-21 11:55:00", DateUtils.DEFAULT_TIME_FORMAT_STRING_MIN);
        boolean flag = date2.before(new Date());
        System.out.println("date1:"+flag);

    }

    @Test
    public void test2(){
//        Duration duration = Duration.ofHours(96);
//        long l = duration.toMillis();
//        System.out.println("min:"+l);
        Duration duration = Duration.ofSeconds(36000);
        long l = duration.toHours();
        System.out.println("lll:"+l);

    }

    @Test
    public void test3(){
        DateTime currentDate = DateTime.now();
//        System.out.println("currentDate:"+currentDate.withHourOfDay(23).withMinuteOfHour(59).isAfter(currentDate));
        System.out.println("currentDate:"+currentDate.dayOfMonth().roundFloorCopy());
    }

    @Test
    public void test4(){
        Date now = new Date();
        long time = now.getTime();
        System.out.println("time:"+time);
    }

    @Test
    public void test5(){
        User user = new User();
        user.setName("beppe");
        Map<String, User> map=new HashMap<>();
        map.put("user",user);
        fillData(map);
        System.out.println("uuuu:"+user.getName());
    }

    private void fillData(Map<String, User> map){
        User user = map.get("user");
        user.setName("nnnn");
    }

    @Test
    public void test6(){
        Boolean flag=null;
        boolean aTrue = BooleanUtils.isTrue(true);
        System.out.println("aTrue:"+aTrue);
    }

    @Test
    public void test7(){
        Date d=null;
        DateTime dateTime = new DateTime(d);
        System.out.println("dateTime:"+ Objects.isNull(d));
    }

    @Test
    public void test8(){
//        Long l=null;
//        boolean aNull = Objects.isNull(l);
//        System.out.println(aNull);
        LocalDateTime parse = LocalDateTime.parse("2021-09-20 13:50");
        System.out.println("parse:"+parse);
    }
}
