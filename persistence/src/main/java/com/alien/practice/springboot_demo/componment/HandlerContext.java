package com.alien.practice.springboot_demo.componment;

import com.alien.practice.springboot_demo.common.BeanTool;

import java.util.Map;

/**
 * 获取具体使用的业务类
 *
 * @author Alien
 * @since 2019/4/9 21:55
 */
public class HandlerContext {
    
    private Map<String, Class> handlerMap;
    
    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }
    
    public AbstractHandler getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("Not found handler for type:" + type);
        }
        return (AbstractHandler) BeanTool.getBean(clazz);
    }
}
