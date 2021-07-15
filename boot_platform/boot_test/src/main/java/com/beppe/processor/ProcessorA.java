package com.beppe.processor;

import com.beppe.common.EventConstant;

import java.util.ArrayList;
import java.util.List;

public class ProcessorA implements Processor {
    @Override
    public List<String> onEvent() {
        List<String> eventList = new ArrayList<>();
        eventList.add(EventConstant.CREATE);
        eventList.add(EventConstant.CANCEL);
        return eventList;
    }

    @Override
    public void execute() {
        System.out.println("执行ProcessorA的逻辑");
    }


}
