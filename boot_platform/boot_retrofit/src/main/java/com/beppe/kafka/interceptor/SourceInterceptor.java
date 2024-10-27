package com.beppe.kafka.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BaseGlobalInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author beppe
 * @data 2020/12/15 20:52
 * @description : 全局应用拦截器
 */
@Slf4j
@Component
public class SourceInterceptor extends BaseGlobalInterceptor {

    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newReq = request.newBuilder()
                .addHeader("source", "test")
                .build();
        log.info("集成拦截器 全局拦截 设置header{}", "BaseGlobalInterceptor");
        return chain.proceed(newReq);
    }
}
