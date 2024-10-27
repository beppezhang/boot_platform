package com.beppe.kafka.api;

import com.beppe.kafka.common.DomainModel;

/**
 * 步骤
 *
 */
public interface ActionStep<Model extends DomainModel> extends ExtensionPoint {

    void execute(Model model, ActionStepContext actionStepContext);
}
