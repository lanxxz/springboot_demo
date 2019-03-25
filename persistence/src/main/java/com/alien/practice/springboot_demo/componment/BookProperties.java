package com.alien.practice.springboot_demo.componment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 书的属性
 * @author Alien
 * @date 2019.03.25
 */
@Component
public class BookProperties {

    /**
     * 书名
     */
    @Value("${demo.book.name}")
    private String name;

    /**
     * 作者
     */
    @Value("${demo.book.writer}")
    private String writer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
