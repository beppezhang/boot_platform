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
 *  项目中继承这个抽象类
 *  执行抽象类中的方法，执行具体的流程
 *
 */
public abstract class AbstractActionStepExecutor<Model extends DomainModel> {

    private final ExtensionCenter extensionCenter;

    public AbstractActionStepExecutor(ExtensionCenter extensionCenter) {
        this.extensionCenter = extensionCenter;
    }

    // 执行入口  model 继承了扩展点框架领域模型的类
    public void execute(Model model){
        // 获取到扩展点
        DecideStepExt decideStepExt = extensionCenter.getExtension(DecideStepExt.class, ExtensionType.STEP_CHOREOGRAPHY_STRATEGY, PointAbilityScenes.STEP_CHOREOGRAPHY_STRATEGY,"app_order");
        // 根据业务编码，获取到扩展点里的业务执行步骤
        List<ActionStepContext> contexts = decideStepExt.decideSteps(model);
        // 执行具体的步骤
        executeStep(model,contexts);
    }

    private void executeStep(Model model,List<ActionStepContext> contexts){
        if(CollectionUtils.isEmpty(contexts)){
            throw new RuntimeException("执行步骤上下文contexts为空");
        }
        for (ActionStepContext context:contexts){
            // 获取具体执行的扩展点
            StepActionExt action = extensionCenter.getExtension(StepActionExt.class, ExtensionType.ACTION_STEP, PointAbilityScenes.ACTION_STEP, "app_order");
            // 执行具体的业务代码
            action.execute(context);
        }
    }


}
