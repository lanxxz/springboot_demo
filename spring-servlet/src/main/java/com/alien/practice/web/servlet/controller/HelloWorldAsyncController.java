package com.alien.practice.web.servlet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Hello World 异步 {@link RestController}
 *
 * @author Alien
 * @since 2019/5/7 23:35
 */
@RestController
public class HelloWorldAsyncController {

    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() {
        // 不填休眠时间为 Tomcat 默认的时间， 此处是休眠 50 毫秒
        DeferredResult<String> result = new DeferredResult<String>(50L);

//        result.setResult("Hello, My World!");
        println("Hello,world!");
        //完成时
        result.onCompletion(() -> {
            println("执行结束！");
        });

        result.onTimeout(() -> {
            println("执行超时");
        });

        return result;
    }

    private void println(Object object) {
        String name = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController Name[" + name + "]: " + object);
    }

}
