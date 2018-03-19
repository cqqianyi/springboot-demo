package com.springboot.demo.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by qianyi on 2018/3/19.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PermissionOperation {

    /**
     * 权限Code
     * @return
     */
    String code();

    /**
     * 权限描述
     * @return
     */
    String description();
}
