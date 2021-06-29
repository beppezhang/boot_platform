package com.beppe.api;

import com.beppe.common.DomainModel;

import java.util.List;

/**
 * 执行步骤
 */
public interface DecideStepsExt<Model extends DomainModel> extends ExtensionPoint{

    List<ActionStepContext> decideSteps(Model model);
}
