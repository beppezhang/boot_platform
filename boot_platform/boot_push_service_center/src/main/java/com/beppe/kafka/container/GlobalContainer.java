package com.beppe.kafka.container;

import com.beppe.kafka.processor.Processor;
import com.beppe.kafka.template.ProcessTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalContainer {

    public static final Map<String, ProcessTemplate> processTemplateMap = new HashMap<>();

    public static final Map<String, List<Processor>> processorListMap = new HashMap<>();
}
