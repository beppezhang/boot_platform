package com.beppe.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComponentContext<T> {

    private String name;
    private Long id;
    private T result;

//    @Data
//    @Builder
//    public class Result<T> {
//
//        private T t;
//
//
//    }
}
