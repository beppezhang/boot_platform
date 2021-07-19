package com.beppe.test;

import com.beppe.entity.Appointment;
import com.beppe.utils.DateUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CircleTest {

    @Test
    public void test1() {
        List<Appointment> appoints = new ArrayList<>();
        List<Date> dates = new ArrayList<>();
        Date date1 = DateUtils.getDate("2021-07-19 14:00:00", DateUtils.DEFAULT_TIME_FORMAT_STRING);
        Date date2 = DateUtils.getDate("2021-07-20 14:00:00", DateUtils.DEFAULT_TIME_FORMAT_STRING);
        Date date3 = DateUtils.getDate("2021-07-21 14:00:00", DateUtils.DEFAULT_TIME_FORMAT_STRING);
        Date slot = DateUtils.getDate("2021-07-22 12:00:00", DateUtils.DEFAULT_TIME_FORMAT_STRING);
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);
        Appointment appointment = new Appointment();
        appointment.setAppointmentDates(dates);
        appoints.add(appointment);
        boolean inAppointent = isInAppointent(appoints, slot);
        System.out.println("是否在履单之间："+inAppointent);

    }

    private boolean isInAppointent(List<Appointment> appoints, Date slotTime) {
        for (Appointment a : appoints) {
            boolean b = compareTime(a, slotTime);
            if(b){
               return true;
            }
        }
        return false;
    }

    private boolean compareTime(Appointment a, Date slotTime) {
        List<Date> appointmentDates = a.getAppointmentDates();
        // 有一个满足即可
        for (Date d : appointmentDates) {
            if (slotTime.after(d)) {
                continue;
            }
            return true;
        }
        return false;
    }


}
