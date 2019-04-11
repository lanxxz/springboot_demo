package com.alien.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@link HelloWorldController} 通知
 *
 * @author Alien
 * @since 2019/4/10 22:44
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage) {
        return acceptLanguage;
    }

//    @ModelAttribute("jsessionId")
//    public String jsessionId(@CookieValue("JSESSIONID") String jsessionId) {
//        return jsessionId;
//    }

    @ModelAttribute("message")
    public String message() {
        return "Hello,World!";
    }

    /**
     * 拦截异常，多种具体异常可以使用 {XXException.class, XXXException.class} 表示
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }

}
