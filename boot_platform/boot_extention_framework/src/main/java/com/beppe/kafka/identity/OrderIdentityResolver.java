package com.beppe.kafka.identity;

import com.beppe.kafka.annotation.BusinessIdentity;
import com.beppe.kafka.api.IdentityResolver;
import com.beppe.kafka.api.PointAbilityScenes;
import com.beppe.kafka.common.OrderExecContext;
import com.beppe.kafka.step.OrderDecideStepExt;

@BusinessIdentity(code = PointAbilityScenes.STEP_CHOREOGRAPHY_STRATEGY, name = "流程编排扩展点身份确认")
public class OrderIdentityResolver implements IdentityResolver<OrderExecContext> {

    @Override
    public String getExtensionCode(OrderExecContext orderExecContext) {
        if(){

        } else if () {

        }else if(){

        }
        return OrderDecideStepExt.APP_ORDER;
    }
}
