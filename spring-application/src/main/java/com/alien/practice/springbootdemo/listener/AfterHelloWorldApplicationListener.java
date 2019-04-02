package com.alien.practice.springbootdemo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * After Hello World {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 * @author: Alien
 * @since: 2019/4/2 22:54
 */
public class AfterHelloWorldApplicationListener
        implements ApplicationListener<ContextRefreshedEvent>, Ordered {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("After Hello World: " + event.getApplicationContext().getId() +
                " ,timestamp: " + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
