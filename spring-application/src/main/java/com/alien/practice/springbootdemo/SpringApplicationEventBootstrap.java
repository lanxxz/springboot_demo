package com.alien.practice.springbootdemo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring framework 应用事件引导类
 * @author: Alien
 * @since: 2019/4/6 13:37
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        //创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听到事件: " + event);
        });

        //启动
        context.refresh();

        //发送事件
        context.publishEvent("Hello world");
        context.publishEvent("2019");
        context.publishEvent(new ApplicationEvent("Alien") {

        });

        //关闭
        context.close();
    }
}
