package com.beppe.kafka.entity;

import lombok.Data;

@Data
public class RecommendedReasonInfo {

    private String recommendedReason;

    private RecommendedReasonMark recommendedReasonMark;

    /**
     * 推荐理由 分城
     */


    @Data
    public static class RecommendedReasonMark{
        private String recommendedReason;
        private Boolean mark;
    }
}
