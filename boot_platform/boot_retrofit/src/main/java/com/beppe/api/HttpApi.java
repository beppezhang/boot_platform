package com.beppe.api;

import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercept;
import com.github.lianjiatech.retrofit.spring.boot.annotation.OkHttpClientBuilder;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.LogStrategy;
import com.github.lianjiatech.retrofit.spring.boot.retry.Retry;
import com.github.lianjiatech.retrofit.spring.boot.retry.RetryRule;
import com.beppe.annotation.Sign;
import com.beppe.bean.User;
import com.beppe.interceptor.CustomInterceptor;
import com.beppe.result.CustomErrorDecoder;
import okhttp3.OkHttpClient;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.concurrent.TimeUnit;

/**
 * @author beppe
 * @data 2020/12/15 19:33
 * @description : 测试http请求接口
 * 实现拦截器 必须加入 Intercept 注解  三个参数 handler 拦截器  include 包含哪些请求经过此拦截器  exclude 排出哪些请求
 * <p>
 * 这边的所有配置 支持 写在配置文件中
 * @Sign(accessKeyId = "${test.accessKeyId}", accessKeySecret = "${test.accessKeySecret}", exclude = {"/api/test/person"})
 */
@RetrofitClient(baseUrl = "http://localhost:8888/", poolName = "test", logStrategy = LogStrategy.BODY, errorDecoder = CustomErrorDecoder.class)
@Intercept(handler = CustomInterceptor.class, include = {"/user/**"}, exclude = "/api/test/savePerson")
@Sign(accessKeyId = "123123", accessKeySecret = "123123", exclude = {"/user"})
public interface HttpApi {

    /**
     * 静态注册 OkHttpClient 的其他属性
     */
    @OkHttpClientBuilder
    static OkHttpClient.Builder okHttpClientBuilder() {
        return new OkHttpClient.Builder()
                // 连接时长
                .connectTimeout(1, TimeUnit.SECONDS)
                // 读数据时长
                .readTimeout(1, TimeUnit.SECONDS)
                // 写数据时长
                .writeTimeout(1, TimeUnit.SECONDS);
    }


    @GET("user/{id}")
    @Retry(maxRetries = 3, intervalMs = 200, retryRules = RetryRule.OCCUR_EXCEPTION)
    User getUser(@Path("id") Integer id);

}
