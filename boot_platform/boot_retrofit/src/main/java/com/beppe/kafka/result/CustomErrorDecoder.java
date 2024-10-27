package com.beppe.kafka.result;

import com.github.lianjiatech.retrofit.spring.boot.core.ErrorDecoder;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author beppe
 * @data 2020/12/15 21:18
 * @description :
 */
@Component
public class CustomErrorDecoder implements ErrorDecoder {

    /**
     * 当无效响应的时候，将HTTP信息解码到异常中，无效响应由业务自行判断。
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public RuntimeException invalidRespDecode(Request request, Response response) {
        return null;
    }

    /**
     * 当请求发生IO异常时，将HTTP信息解码到异常中。     *
     *
     * @param request
     * @param cause
     * @return
     */
    @Override
    public RuntimeException ioExceptionDecode(Request request, IOException cause) {
        return null;
    }

    /**
     * 当请求发生除IO异常之外的其它异常时，将HTTP信息解码到异常中。
     *
     * @param request
     * @param cause
     * @return
     */
    @Override
    public RuntimeException exceptionDecode(Request request, Exception cause) {
        return null;
    }
}
