package com.alien.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Rest 引导类
 *
 * @author Alien
 * @since 2019/4/18 22:37
 */
@SpringBootApplication(scanBasePackages = {
        "com.alien.web.controller",
        "com.alien.web.config"
})
public class SpringBootRestBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class, args);
    }
}
