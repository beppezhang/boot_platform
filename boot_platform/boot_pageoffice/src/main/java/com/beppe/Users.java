package com.beppe;

import java.util.Date;

/**
 * @author beppe
 * @data 2020/9/13 21:57
 * @description :
 */
public class Users {

    private String name;

    private String sex;

    private int age;

    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Users(String name, String sex, int age, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }
}
