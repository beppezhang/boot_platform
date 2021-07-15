package com.beppe.processor;

import java.util.List;

public interface Processor {

        List<String> onEvent();

        void execute();
}
