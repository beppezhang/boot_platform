package com.beppe.container;

import com.beppe.processor.Processor;
import com.beppe.template.ProcessTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalContainer {

    public static final Map<String, ProcessTemplate> processTemplateMap = new HashMap<>();

    public static final Map<String, List<Processor>> processorListMap = new HashMap<>();
}
