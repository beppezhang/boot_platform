package com.beppe.kafka.concurrent.domain;

import java.util.concurrent.Callable;

public class ServerTask implements Callable<Integer> {
    private String name;

    public ServerTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("this is:"+name+"calling");
        Thread.sleep(2000);
        return 5;
    }
}
