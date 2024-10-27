package com.beppe.kafka.api;

import com.beppe.kafka.common.DomainModel;

import java.util.List;

/**
 * 执行步骤
 */
public interface DecideStepsExt<Model extends DomainModel> extends ExtensionPoint{

    List<ActionStepContext> decideSteps(Model model);
}
