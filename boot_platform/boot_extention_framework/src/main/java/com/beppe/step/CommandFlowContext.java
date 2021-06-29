package com.beppe.step;

import com.beppe.commandline.Command;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 命令流程
 */
@Data
public class CommandFlowContext {

    /**
     * 前置校验命令
     */
    private List<Command> preValidCommands = Lists.newArrayList();

    /**
     * 计算命令
     */
    private List<Command> calculateCommands = Lists.newArrayList();
    /**
     * 后置执行命令
     */
    private List<Command> afterCommands = Lists.newArrayList();

    public CommandFlowContext() {
    }


    public static CommandFlowContext instance(){
        return new CommandFlowContext();
    }


    public CommandFlowContext addPreValidCommands(Command... commands){
        preValidCommands.addAll(Arrays.asList(commands));
        return this;
    }

    public CommandFlowContext addCalculateCommands(Command... commands){
        calculateCommands.addAll(Arrays.asList(commands));
        return this;
    }


    public CommandFlowContext addAfterCommands(Command... commands){
        afterCommands.addAll(Arrays.asList(commands));
        return this;
    }


}
