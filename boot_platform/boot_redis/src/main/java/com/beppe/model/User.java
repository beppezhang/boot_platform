package com.beppe.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author beppe
 * @data 2021/1/14 09:45
 * @description :
 */
public class User implements Serializable {

    private String username;

    private String job;

    private int age;

    List<Classes> classes;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                ", classes=" + classes +
                '}';
    }
}
