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

//    方式 一
//    @RequestMapping("")
//    public String index(@RequestHeader("Accept-Language") String acceptLanguage,
//                        @CookieValue("JSESSIONID") String jsessionId,
//                        Model model) {
//        model.addAttribute("message", "Hello,World!");
//        model.addAttribute("acceptLanguage", acceptLanguage);
//        model.addAttribute("jsessionId", jsessionId);
//        return "index";
//    }

//    方式二
//    @RequestMapping("")
//    public String index(Model model) {
//
//        return "index";
//    }

//    @ModelAttribute("acceptLanguage")
//    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
//        return acceptLanguage;
//    }
//
//    @ModelAttribute("jsessionId")
//    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId) {
//        return jsessionId;
//    }
//
//    @ModelAttribute("message")
//    public String message() {
//        return "Hello,World!";
//    }

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
