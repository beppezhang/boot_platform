package com.beppe.kafka.proxy.statictype;
/**
 * 拆单的代理类，在代理类中组合具体的拆单模式  对客户端无感
 * 通常在有多个策略时  需要这个代理来组合各种策略执行   对客户端暴露一个拆单方法
 */
public class ProxySplitStrategy implements SplitStrategy{

    private SplitStrategy currentDaySplitStrategy;
    private SplitStrategy nextDaySplitStrategy;

    public ProxySplitStrategy() {
        currentDaySplitStrategy = new CurrentDaySplitStrategy();
        nextDaySplitStrategy =new  NextDaySplitStrategy();
    }

    @Override
    public void split() {
        currentDaySplitStrategy.split();
        nextDaySplitStrategy.split();
    }
}
