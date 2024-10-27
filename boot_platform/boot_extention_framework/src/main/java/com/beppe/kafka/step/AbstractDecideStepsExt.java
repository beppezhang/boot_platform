package com.beppe.kafka.step;

import com.beppe.kafka.api.ActionStepContext;
import com.beppe.kafka.api.DecideStepsExt;
import com.beppe.kafka.common.OrderExecContext;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 执行步骤的父类
 */
public abstract class AbstractDecideStepsExt implements DecideStepsExt<OrderExecContext> {

    // 获取执行步骤
    @Override
    public List<ActionStepContext> decideSteps(OrderExecContext orderExecContext) {
         if(orderExecContext==null || StringUtils.isBlank(orderExecContext.getActionCode())){
            return null;
        }
        return getDecideSteps(orderExecContext);
    }

    protected abstract List<ActionStepContext> getDecideSteps(OrderExecContext orderExecContext);
}
