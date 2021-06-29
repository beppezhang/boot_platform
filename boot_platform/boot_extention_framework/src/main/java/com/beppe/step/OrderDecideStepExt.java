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
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Extension(type = ExtensionType.STEP_CHOREOGRAPHY_STRATEGY, point = PointAbilityScenes.STEP_CHOREOGRAPHY_STRATEGY, code = OrderDecideStepExt.YHSHOP_ORDER)
public class OrderDecideStepExt {

    public final static String YHSHOP_ORDER = BusinessTypeCode.APP_ORDER;
    // 策略容器   项目启动的时候注册到容器中
    private static Map<String, List<ActionStepContext>> actionEventStepsRegistry = new HashMap<>();

    // 注册
    public OrderDecideStepExt(){
        //预览订单
        List<ActionStepContext> placeActionSteps = Lists.newArrayList();
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

        //创建订单
        List<ActionStepContext> confirmActionSteps = Lists.newArrayList();
        ActionStepContext createOrderEvent = new ActionStepContext<>(ActionStepType.AS_CREATE_ORDER,
                CommandFlowContext.instance()
                        .addCalculateCommands(
                                new CalCommand()
                        )
                        .addAfterCommands(
                             new AfterCommand()
                        ));
        confirmActionSteps.add(createOrderEvent);

        ActionStepContext createOrderZeroOnlinePaymentOkEvent = new ActionStepContext<>(ActionStepType.AS_PAYMENT_OK,
                ActionStepConditionCode.ZERO_ONLINE_PAYMENT_OK,
                buildPaymentOk());

        confirmActionSteps.add(createOrderZeroOnlinePaymentOkEvent);

        confirmActionSteps.add(buildShipmentComplete());
        actionEventStepsRegistry.put(ActionCodeEnum.CONFIRM_ORDER.getCode(), confirmActionSteps);

        //支付完成
        List<ActionStepContext> paymentOkActionSteps = Lists.newArrayList();
        ActionStepContext paymentOkEvent = new ActionStepContext<>(ActionStepType.AS_PAYMENT_OK,
                buildPaymentOk());
        paymentOkActionSteps.add(paymentOkEvent);

        paymentOkActionSteps.add(buildShipmentComplete());
        actionEventStepsRegistry.put(ActionCodeEnum.PAYMENT_OK_ORDER.getCode(), paymentOkActionSteps);
    }
}
