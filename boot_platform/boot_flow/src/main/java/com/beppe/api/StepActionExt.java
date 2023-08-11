package com.beppe.api;

import com.beppe.context.ActionStepContext;
import com.beppe.model.DomainModel;

public interface StepActionExt <Model extends DomainModel> extends ExtentionPoint{

    // 具体实现可以在项目中实现，或者通过抽象类来实现  第一版：直接在项目中实现
    void execute(Model model,ActionStepContext context);
}
