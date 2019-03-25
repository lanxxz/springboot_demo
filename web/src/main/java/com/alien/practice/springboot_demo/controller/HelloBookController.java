package com.alien.practice.springboot_demo.controller;

import com.alien.practice.springboot_demo.componment.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书的前端处理页面
 * @author Alien
 * @date 2019.03.25
 */
@RestController
public class HelloBookController {

    @Autowired
    public BookProperties bookProperties;

    @GetMapping("/book/hello")
    public String sayHello() {
        StringBuilder helloBuilder = new StringBuilder();
        String s = "";
        try {
            //gb2312 utf-8 ISO8859-1 等常见编码格式
            s = new String(bookProperties.getName().getBytes("ISO8859-1"), "gb2312");
        } catch (Exception e) {
            System.err.println("编码转换错误。");
        }
        helloBuilder.append("Hello,").append(bookProperties.getWriter()).append(" is writing ")
                .append(s).append("!");
        return helloBuilder.toString();
    }
}
