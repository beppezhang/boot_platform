package com.beppe.context;

import com.beppe.model.DomainModel;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class MyOrderExeContext implements DomainModel{

    /**
     * 行为编码 (执行动作)
     */
    private String actionCode;

    /**
     * 操作人
     */
    private String operator;



    /**
     * 订单id
     */
    private Long orderId;

    private Map<String, Object> parameters = new HashMap<>();

    public void setParameter(String var, Object obj) {
        parameters.put(var, obj);
    }

    public Object getParameter(String var) {

        return parameters.get(var);
    }

}
