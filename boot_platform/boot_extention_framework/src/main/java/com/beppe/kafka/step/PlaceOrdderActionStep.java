package com.beppe.kafka.step;

import com.beppe.kafka.api.ActionStepContext;
import com.beppe.kafka.common.OrderExecContext;

public class PlaceOrdderActionStep extends AbstractActionStep<OrderExecContext, CommandFlowContext>{


    @Override
    public void toExecute(OrderExecContext model, ActionStepContext<CommandFlowContext> actionStepContext) {

    }
}
