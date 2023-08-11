package com.beppe.executor;

import com.beppe.api.DecideStepExt;
import com.beppe.api.ExtensionType;
import com.beppe.api.PointAbilityScenes;
import com.beppe.api.StepActionExt;
import com.beppe.context.ActionStepContext;
import com.beppe.model.DomainModel;
import com.beppe.register.ExtensionCenter;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *  项目中继承这个抽象类   调用里面的执行方法
 * 执行器抽象类
 */
public class AbstractActionStepExecutor<Model extends DomainModel> {

    private final ExtensionCenter extensionCenter;

    public AbstractActionStepExecutor(ExtensionCenter extensionCenter) {
        this.extensionCenter = extensionCenter;
    }

    // 执行入口
    public void execute(Model model){
        // 获取到执行步骤扩展点
        DecideStepExt decideStepExt = extensionCenter.getExtension(DecideStepExt.class, ExtensionType.STEP_CHOREOGRAPHY_STRATEGY, PointAbilityScenes.STEP_CHOREOGRAPHY_STRATEGY, model);
        // 获取具体的流程
        List<ActionStepContext> actionStepContexts= decideStepExt.decideSteps(model);
        executeActionStep(model,actionStepContexts);
    }

    private void executeActionStep(Model model, List<ActionStepContext> actionStepContexts){
        if(CollectionUtils.isEmpty(actionStepContexts)){
            System.out.println("获取到的执行步骤为空");
        }
        for(ActionStepContext actionStepContext:actionStepContexts){

            StepActionExt actionStep = extensionCenter.getExtension(StepActionExt.class, ExtensionType.ACTION_STEP, PointAbilityScenes.ACTION_STEP,
                    actionStepContext.getActionStepCode());
            if(actionStep == null){
                System.out.println("获取到的执行步骤为空");
            }
            actionStep.execute(model,actionStepContext);
        }
    }


}
