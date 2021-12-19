package com.beppe.executor;

import com.beppe.api.DecideStepExt;
import com.beppe.register.ExtensionCenter;

/**
 *  项目中继承这个抽象类   调用里面的执行方法
 * 执行器抽象类
 */
public class AbstractActionStepExecutor {

    private final ExtensionCenter extensionCenter;

    public AbstractActionStepExecutor(ExtensionCenter extensionCenter) {
        this.extensionCenter = extensionCenter;
    }

    // 执行入口
    public void execute(String type,String point,String code){
        // 获取到执行步骤扩展点
        DecideStepExt decideStepExt = extensionCenter.getExtension(DecideStepExt.class, type, point, code);
        // 获取具体的流程
        decideStepExt.decideSteps(ActionStepContext );
    }


}
