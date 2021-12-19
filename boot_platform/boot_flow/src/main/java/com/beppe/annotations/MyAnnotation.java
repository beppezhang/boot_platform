package com.beppe.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解   可以将自定义注解 加在项目的类上
 * sdk  开发常用的方式： sdk 中定义注解，项目中使用这个注解， sdk 中获取项目中的实例，调用具体的方法
 *
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Component
public @interface MyAnnotation {

    String value() default "";

    String type();

    String code();

    String point();

    String desc() default "";
}
