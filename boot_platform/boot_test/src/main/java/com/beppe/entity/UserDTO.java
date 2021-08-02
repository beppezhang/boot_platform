package com.beppe.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDTO {

    private int id;

    private String name;

    private List<User> users;

    public void doProcess(){
        System.out.println("doing the process");
    }

    public void execute(){
        System.out.println("doing the execute");
    }


}
