package com.alien.web.http.method.support;

import com.alien.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * {@link Properties} {@link HandlerMethodReturnValueHandler} 实现
 *
 * @author Alien
 * @since 2019/4/29 22:17
 */
public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {


    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return Properties.class.equals(returnType.getParameterType());
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType,
                         ModelAndViewContainer mavContainer, NativeWebRequest webRequest)
            throws Exception {

        //强制转换
        Properties properties = (Properties) returnValue;

        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();

        ServletWebRequest request = (ServletWebRequest) webRequest;
        //获取 Servlet Request 对象
        HttpServletRequest httpServletRequest = request.getRequest();

        // 获取 请求头 Content-Type
        String contentType = httpServletRequest.getHeader("Content-Type");
        MediaType mediaType = MediaType.parseMediaType(contentType);

        //获取 Servlet Rsponse 对象
        HttpServletResponse response = request.getResponse();

        HttpOutputMessage message = new ServletServerHttpResponse(response);

        //将 PropertiesHttpMessageConverter 输出
        converter.write(properties, mediaType, message);


    }
}
