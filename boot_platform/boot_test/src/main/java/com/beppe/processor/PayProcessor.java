package com.beppe.processor;

import com.beppe.annotation.Register;
import com.beppe.common.StrategyProcessor;

import java.util.ArrayList;
import java.util.List;

@Register(code = "paycenter",topic = "order_status_change",type = "pay")
public class PayProcessor implements StrategyProcessor {

    @Override
    public List<String> getStrategies() {
        List list = new ArrayList();
        list.add("done");
        list.add("return");
        return list;
    }
}
