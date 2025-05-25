package com.beppe.kafka.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ComponentContext<T> {

    private String name;
    private Long id;
    private T result;
    private List<String> stationIds;

}
