package com.beppe.myorder;


import com.beppe.context.MyOrderExeContext;
import com.beppe.executor.ActionStepExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 预览订单
@Component
public class PlaceOrder {

    private final ActionStepExecutor actionStepExecutor;

    @Autowired
    public PlaceOrder(ActionStepExecutor actionStepExecutor) {
        this.actionStepExecutor = actionStepExecutor;
    }

    public String place(){
        // 构造订单预览行为事件
        MyOrderExeContext myOrderExeContext = new MyOrderExeContext();
        // 流程编排框架执行方法
        actionStepExecutor.execute(myOrderExeContext);
        return "success";
    }
}
