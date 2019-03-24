package com.alien.practice.springboot_demo.annotation;

import com.alien.practice.springboot_demo.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 激活 HelloWorld 模块
 * @author Alien
 * @date 2019.03.25
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class)
//@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
