package com.alien.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Web MVC 引导类
 *
 * @author Alien
 * @since 2019/4/11 23:51
 */
@SpringBootApplication(scanBasePackages = "com.alien.web")
public class SpringWebMvcBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebMvcBootstrap.class, args);
    }
}
