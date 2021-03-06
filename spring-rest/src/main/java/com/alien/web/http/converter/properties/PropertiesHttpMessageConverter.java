package com.alien.web.http.converter.properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Properties;

/**
 * {@link Properties} {@link HttpMessageConverter} 实现
 *
 * @author Alien
 * @since 2019/4/24 23:00
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMessageConverter() {
        // 设置支持的媒体类型 MediaType
        super(new MediaType("text", "properties"));
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        // properties -> String
        //获取请求头
        HttpHeaders headers = outputMessage.getHeaders();
        //从请求头 Content-Type 解析编码
        MediaType contentType = headers.getContentType();
        //获取字符编码
        Charset charset = contentType.getCharset();
        //如果字符编码不存在 则采用默认编码 UTF-8
        charset = charset == null? Charset.forName("UTF-8"): charset;
        //字节输出流
        OutputStream outputStream = outputMessage.getBody();
        //字符输出流
        Writer writer = new OutputStreamWriter(outputStream, charset);

        //properties 写入到字符输出流
        //第二个参数可以添加注释
        properties.store(writer, "Form PropertiesHttpMessageConverter " + new Date());
    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        // 获取请求头
        HttpHeaders headers = inputMessage.getHeaders();
        //从请求头 Content-Type 解析编码
        MediaType contentType = headers.getContentType();
        //获取字符编码
        Charset charset = contentType.getCharset();
        //如果字符编码不存在 则采用默认编码 UTF-8
        charset = charset == null? Charset.forName("UTF-8"): charset;

        //加载字节流
        InputStream inputStream = inputMessage.getBody();
        InputStreamReader reader = new InputStreamReader(inputStream, charset);

        Properties properties = new Properties();
        //加载字符流成为 Properties 对象
        properties.load(reader);

        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        return readInternal(null, inputMessage);
    }
}
