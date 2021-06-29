package com.beppe.api;

import com.beppe.common.DomainModel;

/**
 * 步骤
 *
 */
public interface ActionStep<Model extends DomainModel> extends ExtensionPoint {

    void execute(Model model, ActionStepContext actionStepContext);
}
