package com.alien.web.config;

import com.alien.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * REST {@link WebMvcConfigurer} 实现
 *
 * @author Alien
 * @since 2019/4/24 23:18
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 添加 消息转换器 Converter
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new PropertiesHttpMessageConverter());
    }
}
