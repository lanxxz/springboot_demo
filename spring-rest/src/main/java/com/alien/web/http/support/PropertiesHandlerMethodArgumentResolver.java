package com.alien.web.http.support;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link Properties} 类型 {@link HandlerMethodArgumentResolver}
 *
 * @author Alien
 * @since 2019/4/28 22:41
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        //Servlet request API
        HttpServletRequest request = servletWebRequest.getRequest();
        //获取请求头 Content-Type 中的媒体类型
        String contentType = request.getHeader("Content-Type");
        MediaType mediaType = MediaType.parseMediaType(contentType);
        //获取字符编码
        Charset charset = mediaType.getCharset();
        charset = charset == null? Charset.forName("UTF-8"): charset;
        //请求输入字节流
        ServletInputStream inputStream = request.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        //加载字节流成 Properties 对象
        Properties properties = new Properties();
        properties.load(reader);
        return properties;
    }
}
