package com.beppe.kafka.commandline;

public class CalCommand implements Command {

    @Override
    public void execute() {
        System.out.println("执行计算流程");
    }
}
