package com.beppe.kafka.service;

import com.beppe.kafka.container.GlobalContainer;
import com.beppe.kafka.template.ProcessTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProcessServiceImpl implements ProcessService {


    @Override
    public void coreProcess() {
        ProcessTemplate coreTemplate = GlobalContainer.processTemplateMap.get("core");
        coreTemplate.process();
    }

    @Override
    public void otherProcess() {
        ProcessTemplate otherTemplate = GlobalContainer.processTemplateMap.get("other");
        otherTemplate.process();
    }

    @Override
    public void externalProcess() {
        ProcessTemplate externalTemplate = GlobalContainer.processTemplateMap.get("external");
        externalTemplate.process();
    }
}
