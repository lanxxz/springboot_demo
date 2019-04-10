package com.alien.web.servlet.support;

import com.alien.web.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Srping MVC Web 自动装配 的默认实现
 *
 * @author Alien
 * @since 2019/4/10 23:51
 */
public class DefaultAnnotationConfigDispatcherServletInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() { //web.xml
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() { //DispatcherServlet
        return new Class[] { DispatcherServletConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() { //Servlet Mapping 映射
        return new String[] {"/"};
    }
}
