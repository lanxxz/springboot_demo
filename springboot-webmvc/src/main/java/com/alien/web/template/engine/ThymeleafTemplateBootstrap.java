package com.alien.web.template.engine;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * Thymeleaf 模板引擎 引导类
 *
 * @author Alien
 * @since 2019/4/12 22:40
 */
public class ThymeleafTemplateBootstrap {

    public static void main(String[] args) {
        //构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        //创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hi, Alien!");
        //模板内容
        String content = "<p th:text=\"${message}\">!!!</p>";
        //渲染处理结果
        String result = templateEngine.process(content, context);
        //输出渲染处理结果
        System.out.println(result);
    }
}
