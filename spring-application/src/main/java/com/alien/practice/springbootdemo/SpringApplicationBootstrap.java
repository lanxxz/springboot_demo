package com.alien.practice.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringBootApplication} 引导类
 * @author Alien
 * @since  2019/03/31
 */
//@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        //第一种
        ///SpringApplication.run(SpringApplicationBootstrap.class, args);

        //第二种
        //SpringApplication.run(ApplicationConfiguration.class, args);

        //第三种
        //new SpringApplication(ApplicationConfiguration.class).run(args);

        //第四种
        Set<String> sources = new HashSet<>();
        //配置 Class 名称
        sources.add(ApplicationConfiguration.class.getName());
        SpringApplication application = new SpringApplication();
        application.setSources(sources);
        //设置为非 Web 模式
//        application.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = application.run(args);

        System.out.println("Bean is " + context.getBean(ApplicationConfiguration.class));


    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
