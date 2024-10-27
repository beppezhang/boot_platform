package com.beppe.kafka.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author beppe
 * @data 2020/12/15 20:17
 * @description : 集成 BasePathMatchInterceptor 基础路径匹配拦截器 显然是用于拦截 请求路径的
 * @Component 如果在 Intercept 的 handler 中 指定了 CustomInterceptor 则 此类可以不交给 Spring管理
 * 在 RetrofitFactoryBean 中 的 getInterceptorInstance 方法中，如果 从Spring容器中没有拿到这个bean 则 通过  interceptorClass.newInstance(); 反射创建这个bean
 * 所以在这里 我们最好还是将其交给Spring管理
 */
@Slf4j
@Component
public class CustomInterceptor extends BasePathMatchInterceptor {

    @Override
    protected Response doIntercept(Chain chain) throws IOException {
        // 拿到 Request 请求
        Request request = chain.request();
        HttpUrl url = request.url();
        long timestamp = System.currentTimeMillis();
        HttpUrl newUrl = url.newBuilder()
                .addQueryParameter("timestamp", String.valueOf(timestamp))
                .build();
        Request newRequest = request.newBuilder()
                .url(newUrl)
                .build();
        log.info("集成拦截器 增加参数{}", "BasePathMatchInterceptor");
        return chain.proceed(newRequest);
    }
}
