package com.beppe.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private int id;

    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMatch(String name){
        return Objects.equals(name,"beppe2");
    }

    public List<Strategy> strategies(){
        List<Strategy> list = new ArrayList<>();
//        list.add(new Strategy());
//        list.add(new );
//        list.add("beppe3");
//        list.add("beppe4");
        return list;
    }
}
