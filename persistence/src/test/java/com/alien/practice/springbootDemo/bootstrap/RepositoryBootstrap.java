package com.alien.practice.springbootDemo.bootstrap;

import com.alien.practice.springboot_demo.repository.MyFirstLeaveRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.alien.practice.springboot_demo.repository")
public class RepositoryBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MyFirstLeaveRepository repository =
                context.getBean("myFirstLeaveRepository", MyFirstLeaveRepository.class);
        System.out.println("myFirstLeaveRepository bean: "+repository);

        context.close();
    }
}
