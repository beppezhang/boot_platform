package com.beppe.kafka.interceptor;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author beppe
 * @data 2020/12/15 20:26
 * @description :
 */
@Slf4j
@Component
public class SignInterceptor extends BasePathMatchInterceptor {

    /**
     * 密钥 key
     */
    private String accessKeyId;

    /**
     * 密钥
     */
    private String accessKeySecret;

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    @Override
    public Response doIntercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newReq = request.newBuilder()
                .addHeader("accessKeyId", accessKeyId)
                .addHeader("accessKeySecret", accessKeySecret)
                .build();
        log.info("集成拦截器 增加密钥{}", "BasePathMatchInterceptor");
        return chain.proceed(newReq);
    }
}
