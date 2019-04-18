package com.alien.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World {@link RestController} 实现
 *
 * @author Alien
 * @since 2019/4/18 22:41
 */
@RestController
public class HelloWorldRestController {

    @GetMapping("/hello-world")
    public String helloWorld(@RequestParam(required = false) String massage) {
        return "hello-world:" + massage;
    }
}
