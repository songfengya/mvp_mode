package com.example.day36_depend_inject_demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2016/10/31.
 */
@Target(ElementType.FIELD)  //此注解作用在属性上
@Retention(RetentionPolicy.RUNTIME) // 类运行时 生效
public @interface BindView {
    int value();
}
