package com.alien.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring Web MVC 配置(类)
 * @author: Alien
 * @since: 2019/4/6 22:53
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig {

//    <!--<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver" >-->
//        <!--<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
//        <!--<property name="prefix" value="/WEB-INF/jsp/" />-->
//        <!--<property name="suffix" value=".jsp" />-->
//    <!--</bean>-->
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
