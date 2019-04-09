package com.alien.practice.springboot_demo.componment;

import com.alien.practice.springboot_demo.annotation.HandlerType;
import com.alien.practice.springboot_demo.common.ClassScaner;
import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 扫描 {@link HandlerType} 初始化 {@link HandlerContext} ,将其注册到 SPring 容器
 *
 * @author Alien
 * @since 2019/4/9 21:53
 */
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.alien.practice.springboot_demo.componment.biz";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        HashMap<String, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        ClassScaner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
            //获取注解中的类型值
            String type = clazz.getAnnotation(HandlerType.class).value();
            //将注解中的类型值作为 key, 对应的类作为 value， 保存在 Map 中
            handlerMap.put(type, clazz);
        });

        //初始化 HandlerContext ，将其注册到 Spring 容器中
        HandlerContext context = new HandlerContext(handlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }

}
