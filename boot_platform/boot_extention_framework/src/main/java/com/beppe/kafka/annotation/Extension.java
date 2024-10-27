package com.beppe.kafka.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Component
public @interface Extension {

    @AliasFor(
            annotation = Component.class,
            attribute = "value"
    )
    String value() default "";

    String type();

    String point();

    String code();

    String desc() default "";

    String[] tags() default {};
}
