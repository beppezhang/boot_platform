package com.beppe.model;

import com.beppe.entity.City;
import org.apache.poi.ss.formula.functions.T;

import java.math.BigDecimal;
import java.util.List;

public class UserDto<T> {

    private String name;

    private Integer age;

    private BigDecimal amt;

    private List<City> cityList;

    private T form;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public T getForm() {
        return form;
    }

    public void setForm(T form) {
        this.form = form;
    }
}
