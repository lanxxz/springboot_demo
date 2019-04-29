package com.alien.web.http.method.support;

import com.alien.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
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

        //复用 PropertiesHttpMessageConverter 对象
        PropertiesHttpMessageConverter resolver = new PropertiesHttpMessageConverter();
        //强转成 ServletWebRequest
        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;

        HttpServletRequest request = servletWebRequest.getRequest();

        HttpInputMessage message = new ServletServerHttpRequest(request);

        return resolver.read(null, null, message);
    }
}
