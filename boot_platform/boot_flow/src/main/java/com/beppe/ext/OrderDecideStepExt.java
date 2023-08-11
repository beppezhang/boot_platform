package com.beppe.ext;


import com.beppe.annotations.MyAnnotation;
import com.beppe.api.ExtensionType;
import com.beppe.api.PointAbilityScenes;
import com.beppe.context.ActionStepContext;
import com.beppe.context.MyOrderExeContext;
import com.beppe.executor.AbstractDecideStepsExt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@MyAnnotation(type = ExtensionType.STEP_CHOREOGRAPHY_STRATEGY, point = PointAbilityScenes.STEP_CHOREOGRAPHY_STRATEGY, code = "app_order")
public class OrderDecideStepExt extends AbstractDecideStepsExt {

    // 策略容器   项目启动的时候注册到容器中
    private static Map<String, List<ActionStepContext>> actionEventStepsRegistry = new HashMap<>();

    // 注册
    public OrderDecideStepExt() {
        //预览订单
        List<ActionStepContext> placeActionSteps = new ArrayList<>();
        ActionStepContext placeOrderEvent = new ActionStepContext<>(ActionStepType.AS_PLACE_ORDER,
                CommandFlowContext.instance()
                        .addPreValidCommands(
                                new PreCommand())
                        .addCalculateCommands(
                                new CalCommand())
                        .addAfterCommands(
                                new CalCommand()
                        ));
        placeActionSteps.add(placeOrderEvent);
        actionEventStepsRegistry.put(ActionCodeEnum.PLACE_ORDER.getCode(), placeActionSteps);




    }


    @Override
    protected List<ActionStepContext> getDecideSteps(MyOrderExeContext orderExecContext) {
        return null;
    }
}
