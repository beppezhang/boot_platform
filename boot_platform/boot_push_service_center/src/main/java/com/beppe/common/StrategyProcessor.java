package com.beppe.common;

import java.util.List;

// 定义规范，业务方将服务注册时需要按照这个规范来
public interface StrategyProcessor {

    List<String> getStrategies();
}
