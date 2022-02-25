package com.beppe.executor;

import com.beppe.register.ExtensionCenter;
import org.springframework.stereotype.Component;

@Component
public class ActionStepExecutor extends AbstractActionStepExecutor{

    public ActionStepExecutor(ExtensionCenter extensionCenter) {
        super(extensionCenter);
    }
}
