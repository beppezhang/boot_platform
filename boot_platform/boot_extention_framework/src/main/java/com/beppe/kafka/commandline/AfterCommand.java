package com.beppe.kafka.commandline;

public class AfterCommand implements Command {

    @Override
    public void execute() {
        System.out.println("执行后置流程");
    }
}
