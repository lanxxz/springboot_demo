package com.alien.practice.springbootDemo.bootstrap;

import com.alien.practice.springboot_demo.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link CalculateService} 引导类
 * @author Alien
 * @date 2019.03.25
 */
@SpringBootApplication(scanBasePackages = "com.alien.practice.springboot_demo.service")
public class CalculateServiceBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        CalculateService calculateService = context.getBean(CalculateService.class);

        System.out.println("calculateService.sum(1, 2, ... , 10) " +
                calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    }
}
