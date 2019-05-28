package com.alien.practice.boot.web.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Spring boot servlet 引导类
 *
 * @author Alien
 * @since 2019/5/23 23:33
 */
@EnableAutoConfiguration
@ServletComponentScan(basePackages = "com.alien.practice.web.servlet")
public class SpringBootServletBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletBootstrap.class, args);
    }

}
