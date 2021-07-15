package com.beppe.processor;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 中央控制器   用于注册每个processor
 */
public class CentralControl {

    private List<Processor> list = new ArrayList<>();

    public CentralControl() {
        list.add(new ProcessorA());
        list.add(new ProcessorB());
        list.add(new ProcessorC());

    }

    public void doProcess(String event) {
        //1  找到匹配的  处理器
        List<Processor> processors = list.stream().filter(p -> isMatch(p, event)).collect(Collectors.toList());
        // 2:执行对应的processor
        if (!CollectionUtils.isEmpty(processors)) {
            processors.forEach(p->p.execute());
        }
    }

    private boolean isMatch(Processor p, String event) {
        List<String> events = p.onEvent();
        if (events.contains(event)) {
            return true;
        }
        return false;
    }
}
