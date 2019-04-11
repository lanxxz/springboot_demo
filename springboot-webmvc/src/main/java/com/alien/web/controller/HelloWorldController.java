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
     * {@link RequestParam} 传入参数value 且为数值
     * @param value
     * @param model
     * @return
     */
    @RequestMapping("")
    public String index(@RequestParam int value, Model model) {

        return "index";
    }

}
