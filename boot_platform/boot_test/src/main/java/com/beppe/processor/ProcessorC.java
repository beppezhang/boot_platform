package com.beppe.processor;

import com.beppe.common.EventConstant;

import java.util.ArrayList;
import java.util.List;

public class ProcessorC implements Processor{
    @Override
    public List<String> onEvent() {
        List<String> eventList = new ArrayList<>();
        eventList.add(EventConstant.PAYOK);
        eventList.add(EventConstant.CANCEL);
        eventList.add(EventConstant.REFUND);
        return eventList;
    }

    @Override
    public void execute() {
        System.out.println("执行ProcessorC的逻辑");
    }
}
