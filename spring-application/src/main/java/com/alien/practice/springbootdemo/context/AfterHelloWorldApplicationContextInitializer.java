package com.alien.practice.springbootdemo.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

import javax.sound.midi.SoundbankResource;

/**
 * After HelloWorldApplicationContextInitializer
 * @author: Alien
 * @since: 2019/4/1 23:46
 */
public class AfterHelloWorldApplicationContextInitializer <C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer<C>, Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("After application.id = " + applicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
