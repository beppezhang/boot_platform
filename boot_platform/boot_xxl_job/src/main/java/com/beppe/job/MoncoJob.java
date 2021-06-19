package com.beppe.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author beppe
 * @data 2020/8/5 14:40
 * @description :
 */
@Slf4j
@Component
public class MoncoJob {

    @XxlJob("moncoJobHandler")
    public ReturnT<String> execute(String param) {
        log.info("执行成功");
        return ReturnT.SUCCESS;
    }
}
