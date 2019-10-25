package com.bohui.wf.gps.website.webpage.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 */


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    String value() default "管理员日志";
}
