package com.alien.web.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Thymeleaf 模板引擎 引导类
 *
 * @author Alien
 * @since 2019/4/12 22:40
 */
public class ThymeleafTemplateBootstrap {

//    public static void main(String[] args) {
//        //构建引擎
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        //创建渲染上下文
//        Context context = new Context();
//        context.setVariable("message", "Hi, Alien!");
//        //模板内容
//        String content = "<p th:text=\"${message}\">!!!</p>";
//        //渲染处理结果
//        String result = templateEngine.process(content, context);
//        //输出渲染处理结果
//        System.out.println(result);
//    }

    public static void main(String[] args) throws IOException {
        //构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        //创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hi, Alien!");

        //读取内容 从 classpath:/templates/thymeleaf/hello-world.html
        //ResourceLoader
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        //通过 classpath 获取 Resource
        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-world.html");
        File templateFile = resource.getFile();

        //文件输入输出流
        FileInputStream inputStream = new FileInputStream(templateFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //复制 流 的内容
        IOUtils.copy(inputStream, outputStream);

        //模板内容
        String content = outputStream.toString("UTF-8");
        //渲染处理结果
        String result = templateEngine.process(content, context);
        //输出渲染处理结果
        System.out.println(result);

        //关闭流
        inputStream.close();
        outputStream.close();
    }
}
