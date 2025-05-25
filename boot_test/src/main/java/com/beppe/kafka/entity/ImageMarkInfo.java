package com.beppe.kafka.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ImageMarkInfo {

    @NonNull
    private Long templateId;

    private Boolean imageListMark;

    private Boolean imageDetailMark;

    @Data
//    @JsonNaming(CamelToUnderlineJsonNamingConfig.class)
    public static class CityInfo {
        /**
         * 城市code
         */
        private String cityId;
        /**
         * 城市名称
         */
        private String cityName;

        // 这两个字段是为了兼容之前的结构，之前是下划线，现在是驼峰
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String city_id;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String city_name;

        public void setCity_id(String city_id) {
            this.city_id = city_id;
            this.setCityId(city_id);
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
            this.setCityName(city_name);
        }
    }
}
