package com.alien.practice.springbootdemo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Hello World {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 * @author: Alien
 * @since: 2019/4/2 22:48
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener
        implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Hello World: " + event.getApplicationContext().getId() +
                " ,timestamp: " + event.getTimestamp());
    }
}
