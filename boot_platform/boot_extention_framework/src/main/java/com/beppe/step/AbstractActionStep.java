package com.beppe.step;

import com.beppe.api.ActionStep;
import com.beppe.api.ActionStepContext;
import com.beppe.common.DomainModel;

public abstract class AbstractActionStep<Model extends DomainModel,StepFlowContext> implements ActionStep<Model> {

    @Override
    public void execute(Model model, ActionStepContext actionStepContext) {
        toExecute(model,actionStepContext);
    }

    public abstract void toExecute(Model model,ActionStepContext<StepFlowContext> actionStepContext);
}
