package com.alien.practice.springbootdemo.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author: Alien
 * @since: 2019/4/1 23:41
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer<C> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ConfigurableApplicationContext.id is " + applicationContext.getId());
    }
}
