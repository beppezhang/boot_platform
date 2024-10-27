package com.beppe.kafka.service;

// 对外暴露相应的策略接口，调用方不需要去选择具体注入那个类
public interface ProcessService {

    void coreProcess();

    void otherProcess();

    void externalProcess();
}
