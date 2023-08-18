package com.beppe.executor;

import com.beppe.api.DecideStepExt;
import com.beppe.context.ActionStepContext;
import com.beppe.context.MyOrderExeContext;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * description: AbstractDecideStepsExt <br>
 * date: 2021/2/4 下午2:25 <br>
 * author: dengbo <br>
 */
public abstract class AbstractDecideStepsExt implements DecideStepExt<MyOrderExeContext> {

    @Override
    public List<ActionStepContext> decideSteps(MyOrderExeContext myOrderExeContext) {
        if(myOrderExeContext==null || StringUtils.isBlank(myOrderExeContext.getActionCode())){
            return null;
        }
        return getDecideSteps(myOrderExeContext);
    }

    protected abstract List<ActionStepContext> getDecideSteps(MyOrderExeContext orderExecContext);

}
