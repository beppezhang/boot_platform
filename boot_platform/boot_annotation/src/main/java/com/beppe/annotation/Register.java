package com.beppe.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 *  注册 注解标识  用该注解标识的类表示需要被注册的
 * @author beppe
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Component
public @interface Register {

    // 编码    用于记录
    String code();

    //  类型   用于区分业务方
    String type();

    //  主题
    String topic();
}
