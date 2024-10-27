package com.beppe.kafka.command.iml;

import com.beppe.kafka.command.Command;
import com.beppe.kafka.command.OrderCommandContext;
import com.beppe.kafka.command.OrderCommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderCommandFactoryImpl implements OrderCommandFactory {

    // 注入所有的命令行  以list 的形式注入
    private List<Command> commands;

    @Autowired
    public OrderCommandFactoryImpl(List<Command> commands) {
        this.commands = commands;
        // 初始化的时候去注册
        registerCommand();
    }

    // 定义策略容器  用于将命令行类注册到容器中
    private final Map<String, Command> commandByKey = new HashMap<>();

    @Override
    public void execute(String key, OrderCommandContext commandContext) {
        // 获取到对应的命令行进行执行
        Command command = commandByKey.get(key);
        if (command != null) {
            command.execute(commandContext);
        }

    }

    @Override
    public void registerCommand() {
        commands.forEach(p -> {
            if (!commandByKey.containsKey(p.getCmdKey())) {
                commandByKey.put(p.getCmdKey(), p);
            }
        });
    }


}
