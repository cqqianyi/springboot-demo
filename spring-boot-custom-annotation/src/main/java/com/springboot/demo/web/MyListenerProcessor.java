package com.springboot.demo.web;

import com.springboot.demo.annotation.PermissionOperation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

@Component
public class MyListenerProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        if (methods != null) {
            for (Method method : methods) {
                PermissionOperation permissionOperation = AnnotationUtils.findAnnotation(method, PermissionOperation.class);
                if (null != permissionOperation) {
                    //插入到数据中
                    System.out.println(permissionOperation.code());
                    System.out.println(permissionOperation.description());

                    /**
                     * 权限Code2
                        删除用户
                        权限Code1
                         添加用户
                     */
                }
            }
        }
        return bean;
    }
}