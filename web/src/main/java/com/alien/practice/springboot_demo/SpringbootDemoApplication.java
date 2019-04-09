package com.alien.practice.springboot_demo;

import com.alien.practice.springboot_demo.common.BeanTool;
import com.alien.practice.springboot_demo.common.ClassScaner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDemoApplication {

    @Bean
    public BeanTool getBeanTool() {
        return new BeanTool();
    }

    @Bean
    public ClassScaner getClassScaner() {
        return new ClassScaner();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
