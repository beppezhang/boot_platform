package com.beppe.test;

import com.beppe.utils.DateUtils;
import org.testng.annotations.Test;

import java.util.Date;

public class DateTest {

    @Test
    public void test1(){
//        Date date1 = DateUtils.getDate("2021-07-21 10:00:00", DateUtils.DEFAULT_TIME_FORMAT_STRING);
        Date date2 = DateUtils.getDate("2021-07-21 11:55:00", DateUtils.DEFAULT_TIME_FORMAT_STRING_MIN);
        boolean flag = date2.before(new Date());
        System.out.println("date1:"+flag);

    }
}
