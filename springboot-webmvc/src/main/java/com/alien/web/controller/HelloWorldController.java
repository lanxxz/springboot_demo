package com.alien.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Hello World {@link Controller} <br/>
 * {@link ModelAttribute} 会先于 {@link RequestMapping} 处理 <br/>
 * @author: Alien
 * @since: 2019/4/6 20:25
 */
@Controller
public class HelloWorldController {

    /**
     * {@link RequestParam} 传入参数value 且为数值<br/>
     *  required = false, 设置为非必需
     * @param value
     * @param model
     * @return
     */
    @RequestMapping("")
    public String index(@RequestParam(required = false, defaultValue = "0") int value, Model model) {

        return "index";
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        System.out.println("hello-world.html");
        //View 的逻辑名称
        return "hello-world";
    }

    @ModelAttribute("message2")
    public String message2() {
        System.out.println("message2:Hello, Alien!");
        return "Hello, Alien!";
    }

}
