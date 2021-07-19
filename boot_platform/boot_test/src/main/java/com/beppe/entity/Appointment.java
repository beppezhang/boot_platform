package com.beppe.entity;

import java.util.Date;
import java.util.List;

public class Appointment {

    private List<Date> appointmentDates;

    public List<Date> getAppointmentDates() {
        return appointmentDates;
    }

    public void setAppointmentDates(List<Date> appointmentDates) {
        this.appointmentDates = appointmentDates;
    }
}
