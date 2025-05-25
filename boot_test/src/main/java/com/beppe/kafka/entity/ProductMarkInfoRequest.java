package com.beppe.kafka.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 商品标注 提交流程入参
 * @author: zhangsl
 *
 */
@Data
@Accessors(chain = true)
public class ProductMarkInfoRequest {

    /**
     * 描述
     */
    private String remark;

    private Long productId;

    private String baseName;

    private RecommendedReasonInfo recommendedReasonInfo;


    private List<ImageMarkInfo> imageMarkInfoList;

    @Data
    @NoArgsConstructor
    public static class ImageMarkInfo{

        @NonNull
        private Long templateId;

        private Boolean imageListMark;

        private Boolean imageDetailMark;
    }


}
