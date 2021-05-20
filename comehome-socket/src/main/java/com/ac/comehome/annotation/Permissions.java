package com.ac.comehome.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @program: comehome
 * @description: udp的aop的权限注解
 * @author: ErFeng_V
 * @create: 2021-05-18 12:42
 */
@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface Permissions {

}
