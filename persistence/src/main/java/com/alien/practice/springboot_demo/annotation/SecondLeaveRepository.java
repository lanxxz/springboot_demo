package com.alien.practice.springboot_demo.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 二级仓储 {@link  FirstLeaveRepository}
 * @autor ALien
 * @date 2019-03-14
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLeaveRepository
public @interface SecondLeaveRepository {

    String value() default "";
}
