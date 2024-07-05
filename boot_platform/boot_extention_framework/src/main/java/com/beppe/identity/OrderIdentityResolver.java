package com.beppe.identity;

import com.beppe.annotation.BusinessIdentity;
import com.beppe.api.IdentityResolver;
import com.beppe.api.PointAbilityScenes;
import com.beppe.common.OrderExecContext;
import com.beppe.step.OrderDecideStepExt;

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
