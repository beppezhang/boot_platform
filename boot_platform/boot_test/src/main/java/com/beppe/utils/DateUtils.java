package com.beppe.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DEFAULT_TIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

    public static final String DEFAULT_TIME_FORMAT_STRING_MIN = "yyyy-MM-ddHH:mm";

    public static Date getDate(String sDate, String dateFormat){
        SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
        ParsePosition pos = new ParsePosition(0);
        return fmt.parse(sDate, pos);

    }
}
