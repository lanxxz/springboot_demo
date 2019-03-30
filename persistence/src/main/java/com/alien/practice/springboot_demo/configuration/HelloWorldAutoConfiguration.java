package com.alien.practice.springboot_demo.configuration;

import com.alien.practice.springboot_demo.annotation.EnableHelloWorld;
import com.alien.practice.springboot_demo.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Hello World 自动装配 <br/>
 * Configuration Spring 模式注解 <br/>
 * EnableHelloWorld Spring Enable 模块装配 <br/>
 * ConditionalOnSystemProperty Spring 条件装配 <br/>
 * @author Alien
 * @since 2019/03/30
 */
@Configuration
@EnableHelloWorld
@ConditionalOnSystemProperty(name = "user.name", value = "Alien")
public class HelloWorldAutoConfiguration {


}
