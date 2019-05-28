package com.alien.practice.boot.web.servlet;

import com.alien.practice.web.servlet.AsyncServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Spring boot servlet 引导类
 *
 * @author Alien
 * @since 2019/5/23 23:33
 */
@EnableAutoConfiguration
//@ServletComponentScan(basePackages = "com.alien.practice.web.servlet")
public class SpringBootServletBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletBootstrap.class, args);
    }

//    使用该方法很难改造，会和默认的DispatcherServlet产生冲突
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public AsyncServlet asyncServlet() {
//        return new AsyncServlet();
//    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new AsyncServlet(), "/async-servlet");
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            CharacterEncodingFilter filter = new CharacterEncodingFilter();
            FilterRegistration.Dynamic registration = servletContext.addFilter("filter", filter);
            registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/");
        };
    }
}
