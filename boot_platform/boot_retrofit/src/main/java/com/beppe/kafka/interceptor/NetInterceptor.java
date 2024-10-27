package com.beppe.kafka.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.NetworkInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author beppe
 * @data 2020/12/15 20:55
 * @description :   网络请求拦截器
 */
@Slf4j
@Component
public class NetInterceptor implements NetworkInterceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        log.info("集成拦截器 网络拦截器 需自己实现{}", "NetworkInterceptor");
        return chain.proceed(chain.request());
    }
}
