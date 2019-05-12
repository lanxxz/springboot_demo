package com.alien.practice.web.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 *
 * @author Alien
 * @since 2019/5/7 23:18
 */
//@Configuration
@ComponentScan(basePackages = {
        "com.alien.practice.web.servlet.controller",
        "com.alien.practice.web.servlet.config"
})
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0]; //相当于 web.xml
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { //DispatcherServlet
        return new Class[] {
                getClass() //返回当前类
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; //Servlet Mapping 映射
    }
}
