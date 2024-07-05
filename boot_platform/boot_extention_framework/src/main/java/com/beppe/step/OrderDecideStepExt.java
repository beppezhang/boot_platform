package com.beppe.step;

import com.beppe.annotation.Extension;
import com.beppe.api.ActionStepContext;
import com.beppe.api.ExtensionType;
import com.beppe.api.PointAbilityScenes;
import com.beppe.commandline.AfterCommand;
import com.beppe.commandline.CalCommand;
import com.beppe.commandline.PreCommand;
import com.beppe.common.ActionCodeEnum;
import com.beppe.common.BusinessTypeCode;
import com.beppe.common.OrderExecContext;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Extension(type = ExtensionType.STEP_CHOREOGRAPHY_STRATEGY, point = PointAbilityScenes.STEP_CHOREOGRAPHY_STRATEGY, code = OrderDecideStepExt.APP_ORDER)
public class OrderDecideStepExt extends AbstractDecideStepsExt{

    public final static String APP_ORDER = BusinessTypeCode.APP_ORDER;   组合
    // 策略容器   项目启动的时候注册到容器中
    private static Map<String, List<ActionStepContext>> actionEventStepsRegistry = new HashMap<>();

    // 注册
    public OrderDecideStepExt() {
        //预览订单
        List<ActionStepContext> placeActionSteps = Lists.newArrayList();
        ActionStepContext placeOrderEvent = new ActionStepContext<>(ActionStepType.AS_PLACE_ORDER,
                CommandFlowContext.instance()
                        .addPreValidCommands(
                                new PreCommand(),  //check1
                                new PreCommand()
                              2)
                        .addCalculateCommands(
                                new CalCommand())
                        .addAfterCommands(
                                new CalCommand()
                        ));
        placeActionSteps.add(placeOrderEvent);
        actionEventStepsRegistry.put(ActionCodeEnum.PLACE_ORDER.getCode(), placeActionSteps);

        //创建订单
        List<ActionStepContext> confirmActionSteps = Lists.newArrayList();
        ActionStepContext createOrderEvent = new ActionStepContext<>(ActionStepType.AS_CREATE_ORDER,
                CommandFlowContext.instance()
                        .addCalculateCommands(
                                new CalCommand()   // check2
                        )
                        .addAfterCommands(
                                new AfterCommand()
                        ));
        confirmActionSteps.add(createOrderEvent);
        actionEventStepsRegistry.put(ActionCodeEnum.CONFIRM_ORDER.getCode(), confirmActionSteps);


    }

    // 根据actionCode  获取对应的执行步骤
    @Override
    protected List<ActionStepContext> getDecideSteps(OrderExecContext orderExecContext) {
        return actionEventStepsRegistry.get(orderExecContext.getActionCode());
    }
}
