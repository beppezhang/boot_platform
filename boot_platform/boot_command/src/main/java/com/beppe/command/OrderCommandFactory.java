package com.beppe.command;

/**
 * @auth zsl
 *
 * desc :提供命令行类 工厂  暴露统一的执行方法来执行命令行
 * 调用方不需要引入具体的命令行去执行方法，
 * 只需要引入工厂，通过执行工厂的统一方法来执行命令行
 *
 * 主要有两个方法  1：统一的执行方法  2：注册方法
 */
public interface OrderCommandFactory {

    // 暴露统一的执行方法   通过key 找到对应的命令行类
    // 通过命令行上下文来存放入参和执行结果信息
    void execute(String key,OrderCommandContext commandContext);

    // 注册命令行到容器中
    void registerCommand();
}
