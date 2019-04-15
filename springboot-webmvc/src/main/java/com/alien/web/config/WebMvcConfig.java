package com.alien.web.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Spring Web MVC 配置(类)
 * @author: Alien
 * @since: 2019/4/6 22:53
 */
@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer  {

//    <!--<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver" >-->
//        <!--<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
//        <!--<property name="prefix" value="/WEB-INF/jsp/" />-->
//        <!--<property name="suffix" value=".jsp" />-->
//    <!--</bean>-->
    @Bean
    public ViewResolver myViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        //ThymeleafViewResolver Ordered.LOWEST_PRECEDEENCE - 5
        //优先级设置成高于 ThymeleafViewResolver
        resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 10);
        //配置 ViewResolver 的 Content-Type 页面采用 ?format=xml
        resolver.setContentType("text/xml;charset=UTF-8");
        return resolver;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true) //是否支持请求参数的方式
                .favorPathExtension(true);  //是否支持后缀的方式
//              .parameterName("format")	//请求参数名
//              .defaultContentType(MediaType.APPLICATION_ATOM_XML); //默认返回格式
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

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory -> {
            factory.addContextCustomizers((context) -> {
                String relativePath = "springboot-webmvc/src/main/webapp";
                File docBaseFile = new File(relativePath);
                if (docBaseFile.exists()) {
                    //解决 Maven 多模块 JSP 无法读取的问题
                    context.setDocBase(docBaseFile.getAbsolutePath());
                }
            });
        });
    }


}
