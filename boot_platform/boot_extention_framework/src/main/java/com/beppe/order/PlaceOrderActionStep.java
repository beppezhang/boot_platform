package com.beppe.order;


import com.beppe.annotation.Extension;
import com.beppe.api.ActionStepContext;
import com.beppe.api.ExtensionType;
import com.beppe.api.PointAbilityScenes;
import com.beppe.commandline.Command;
import com.beppe.common.OrderExecContext;
import com.beppe.step.AbstractActionStep;
import com.beppe.step.ActionStepType;
import com.beppe.step.CommandFlowContext;

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
