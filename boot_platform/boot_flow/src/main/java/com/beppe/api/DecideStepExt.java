package com.beppe.api;

import com.beppe.context.ActionStepContext;
import com.beppe.model.DomainModel;
import org.springframework.ui.Model;

import java.util.List;

/**
 * 执行步骤扩展点
 */
public interface DecideStepExt<Model extends DomainModel> extends ExtentionPoint{


    List<ActionStepContext> decideSteps(Model model);
}
