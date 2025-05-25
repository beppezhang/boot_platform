package com.beppe.kafka.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

public class City implements Serializable {
   private String id;
   private String name;

   private Long amount;


   private Date publishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public City() {
    }

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Data
    @EqualsAndHashCode(callSuper = true)
//    @JsonNaming(CamelToUnderlineJsonNamingConfig.class)
    public static class GenericCityInfo<E> extends ImageMarkInfo.CityInfo {
        /**
         * 值
         */
        private E value;

        /**
         * 是否删除 true 删除
         */
        private Boolean isDelete = false;

        /**
         * 标注  true  隐藏
         */
        private Boolean mark = false;
    }
}
