package com.beppe.kafka.order;


import com.beppe.kafka.annotation.Extension;
import com.beppe.kafka.api.ActionStepContext;
import com.beppe.kafka.api.ExtensionType;
import com.beppe.kafka.api.PointAbilityScenes;
import com.beppe.kafka.commandline.Command;
import com.beppe.kafka.common.OrderExecContext;
import com.beppe.kafka.step.AbstractActionStep;
import com.beppe.kafka.step.ActionStepType;
import com.beppe.kafka.step.CommandFlowContext;

import java.util.List;

/**
 * 预览订单
 */
@Extension(type = ExtensionType.ACTION_STEP, point = PointAbilityScenes.ACTION_STEP, code = ActionStepType.AS_PLACE_ORDER)
public class PlaceOrderActionStep extends AbstractActionStep<OrderExecContext, CommandFlowContext> {



    @Override
    public void toExecute(OrderExecContext orderExecContext, ActionStepContext<CommandFlowContext> actionStepContext) {


        calculate(actionStepContext.getStepFlowContext().getPreValidCommands());
        calculate(actionStepContext.getStepFlowContext().getCalculateCommands());

    }

    private void calculate(List<Command> commandList) {
        for (Command calculateCommand : commandList) {
            calculateCommand.execute();
        }
    }



}
