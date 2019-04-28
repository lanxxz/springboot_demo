package com.alien.web.config;

import com.alien.web.http.converter.properties.PropertiesHttpMessageConverter;
import com.alien.web.http.support.PropertiesHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

/**
 * REST {@link WebMvcConfigurer} 实现
 *
 * @author Alien
 * @since 2019/4/24 23:18
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    /**
     * {@link PostConstruct}和{@link PreDestroy}。
     * 这两个注解被用来修饰一个非静态的void()方法.而且这个方法不能有抛出异常声明。<br/>
     *  被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器调用一次，
     *  类似于Serclet的inti()方法。被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。<br/>
     *  被@PreDestroy修饰的方法会在服务器卸载Servlet的时候运行，并且只会被服务器调用一次，类似于Servlet的destroy()方法。
     *  被@PreDestroy修饰的方法会在destroy()方法之后运行，在Servlet被彻底卸载之前。<br/>
     */
    @PostConstruct
    public void init() {
        //获取当前 requestMappingHandlerAdapter 的所有 Resolver 对象
        //返回的 resolvers 是不可变的List
        List<HandlerMethodArgumentResolver> resolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>(resolvers.size() + 1);
        //添加 PropertiesHandlerMethodArgumentResolver 到 集合首位
        newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        //添加 已注册的 Resolver 对象集合
        newResolvers.addAll(resolvers);
        //重新设置 Resolver 对象集合
        requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        // 添加 PropertiesHandlerMethodArgumentResolver 到 集合首位
        // 自定义 HandlerMethodArgumentResolver 优先级低于内建的 HandlerMethodArgumentResolver
//        if (resolvers.isEmpty()) {
//            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
//        } else {
//            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
//        }
    }


    /**
     * 添加 消息转换器 Converter
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //不建议添加到 convertiers 的末尾
//        converters.add(new PropertiesHttpMessageConverter());
        //添加到首位
        converters.set(0, new PropertiesHttpMessageConverter());
    }
}
