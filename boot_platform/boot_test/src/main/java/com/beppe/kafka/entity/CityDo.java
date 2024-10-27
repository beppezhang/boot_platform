package com.beppe.kafka.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

public class CityDo implements Serializable {

    public static CityDo DEFAULT_CITY_DO= getDefaultCityDo();

    public static CityDo getDefaultCityDo(){
        CityDo cityDo = new CityDo();
        cityDo.setAmount(1);
        cityDo.setName("001");
        return cityDo;
    }
   private String id;
   private String name;

   private Integer amount;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
   private String publishTime;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public CityDo() {
    }

    public CityDo(String id, String name) {
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
