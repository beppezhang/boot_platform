package com.beppe.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private int id;

    private String name;


}
