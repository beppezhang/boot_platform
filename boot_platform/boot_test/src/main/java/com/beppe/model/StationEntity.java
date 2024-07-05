package com.beppe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StationEntity {

    private ProductStationMap productStationMap;

    @Getter
    @Setter
    public static class ProductStationMap{
        // key=站点ID，value=组合商品是否开启批次售卖
        Map<String, Boolean> productGroupStationMap = new HashMap<>();
        // 新品站点标签 key=服务站ID
        Map<String, String> productNewStationDoMap = new HashMap<>();
        // id 列表
        List<String> ids= Lists.newArrayList();
    }
}
