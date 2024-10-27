package com.beppe.kafka.executor;

import com.beppe.kafka.register.ExtensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionStepExecutor extends AbstractActionStepExecutor{

    @Autowired
    public ActionStepExecutor(ExtensionRepository extensionRepository) {
        super(extensionRepository);
    }
}
