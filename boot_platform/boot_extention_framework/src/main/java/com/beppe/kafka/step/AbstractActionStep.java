package com.beppe.kafka.step;

import com.beppe.kafka.api.ActionStep;
import com.beppe.kafka.api.ActionStepContext;
import com.beppe.kafka.common.DomainModel;

public abstract class AbstractActionStep<Model extends DomainModel,StepFlowContext> implements ActionStep<Model> {

    @Override
    public void execute(Model model, ActionStepContext actionStepContext) {
        toExecute(model,actionStepContext);
    }

    public abstract void toExecute(Model model,ActionStepContext<StepFlowContext> actionStepContext);
}
