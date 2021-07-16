package com.beppe.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private int id;

    private String name;

    public void doProcess(){
        System.out.println("doing the process");
    }

    public void execute(){
        System.out.println("doing the execute");
    }


}
