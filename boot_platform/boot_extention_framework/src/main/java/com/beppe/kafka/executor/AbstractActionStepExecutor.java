package com.beppe.kafka.executor;

import com.beppe.api.*;
import com.beppe.kafka.api.ActionStep;
import com.beppe.kafka.api.ActionStepContext;
import com.beppe.kafka.api.Condition;
import com.beppe.kafka.api.DecideStepsExt;
import com.beppe.kafka.api.ExtensionType;
import com.beppe.kafka.api.PointAbilityScenes;
import com.beppe.kafka.common.DomainModel;
import com.beppe.kafka.register.ExtensionRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;


public class AbstractActionStepExecutor<Model extends DomainModel> {

    private final ExtensionRepository extensionRepository;

    public AbstractActionStepExecutor(ExtensionRepository extensionRepository) {
        this.extensionRepository = extensionRepository;
    }

    public void execute(Model model){
        // 从扩展点仓库获取对象的扩展点
        DecideStepsExt decideStepsExt = extensionRepository.getExtension(DecideStepsExt.class, ExtensionType.STEP_CHOREOGRAPHY_STRATEGY, PointAbilityScenes.STEP_CHOREOGRAPHY_STRATEGY, model);
        List<ActionStepContext> actionStepContexts = decideStepsExt.decideSteps(model);
        executeActionStep(model,actionStepContexts);
    }

    private void executeActionStep(Model model, List<ActionStepContext> actionStepContexts){
        if(CollectionUtils.isEmpty(actionStepContexts)){
            System.out.println("actionStepContexts 为空");
        }
        for(ActionStepContext actionStepContext:actionStepContexts){
            if(!isApply(model, actionStepContext)){
                return;
            }
            ActionStep actionStep = extensionRepository.getExtension(ActionStep.class, ExtensionType.ACTION_STEP, PointAbilityScenes.ACTION_STEP,
                    actionStepContext.getActionStepCode());
            if(actionStep == null){
                System.out.println("actionStep 为空");
            }
            actionStep.execute(model,actionStepContext);
        }
    }

    private boolean isApply(Model model, ActionStepContext actionStepContext){
        if(StringUtils.isBlank(actionStepContext.getCondition())){
            return true;
        }
        Condition condition = extensionRepository.getExtension(Condition.class, ExtensionType.ACTION_STEP_CONDITION, PointAbilityScenes.ACTION_STEP_CONDITION, actionStepContext.getCondition());
        return condition.isApply(model);
    }


}

