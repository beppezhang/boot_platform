package com.beppe.commandline;

//  折扣店check
public class PreCommand implements Command {

    @Override
    public void execute() {
        System.out.println("执行前置流程");
    }
}
