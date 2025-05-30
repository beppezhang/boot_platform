package com.beppe.kafka.concurrent;

public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    return new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
