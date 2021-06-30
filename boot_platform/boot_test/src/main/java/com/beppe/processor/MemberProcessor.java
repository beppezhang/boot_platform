package com.beppe.processor;


import com.beppe.annotation.Register;
import com.beppe.common.StrategyProcessor;

import java.util.ArrayList;
import java.util.List;

@Register(code = "membercenter",topic = "order_status_change",type = "member")
public class MemberProcessor implements StrategyProcessor {

    @Override
    public List<String> getStrategies() {
        List list = new ArrayList();
        list.add("done");
        list.add("create");
        list.add("cancel");
        return list;
    }
}
