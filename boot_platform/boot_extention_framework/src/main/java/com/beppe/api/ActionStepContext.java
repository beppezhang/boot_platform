package com.beppe.api;

import com.beppe.common.DomainModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionStepContext<StepFlowContext> implements DomainModel {

    private String actionStepCode;

    private String condition;

    private StepFlowContext stepFlowContext;

    public ActionStepContext(String actionStepCode) {
        this.actionStepCode = actionStepCode;
    }

    public ActionStepContext(String actionStepCode, StepFlowContext stepFlowContext) {
        this.actionStepCode = actionStepCode;
        this.stepFlowContext = stepFlowContext;
    }
}
