package com.alien.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring Web MVC 配置(类)
 * @author: Alien
 * @since: 2019/4/6 22:53
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer  {

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {

            /**
             * 说明<br/>
             * preHandle：<br/>
             * 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；<br/>
             * postHandle：<br/>
             * 在业务处理器处理请求执行完成后，生成视图之前执行
             * 后处理（调用了Service并返回ModelAndView，但未进行页面渲染），
             * 有机会修改ModelAndView （这个博主就基本不怎么用了）；<br/>
             * afterCompletion：<br/>
             * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。
             * 返回处理（已经渲染了页面）；<br/>

             *
             */
            @Override
            public boolean preHandle(HttpServletRequest request,
                                     HttpServletResponse response, Object handler) {
                System.out.println("拦截中 ...");
                return  true;
            }

        });
    }

}
