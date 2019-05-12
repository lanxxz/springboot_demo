package com.alien.practice.web.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * Hello World 异步 {@link RestController}
 *
 * @author Alien
 * @since 2019/5/7 23:35
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {

    // 结果处理队列
    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);

    // 超时随机数
    private final Random random = new Random();

    //定时操作
    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException {
        DeferredResult<String> result = null;
        do {
            result = queue.take();
            // 随机超时时间
            int timeout = random.nextInt(100);
            // 模拟等待时间 RPC 或者 DB 查询
            Thread.sleep(timeout);
            //模拟计算结果
            result.setResult("Hello, My World!");
            println("执行计算结果，消耗：" + timeout + " ms.");
        } while (result != null);
    }

    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() {
        // 不填休眠时间为 Tomcat 默认的时间， 此处是休眠 50 毫秒
        DeferredResult<String> result = new DeferredResult<String>(50L);

//        result.setResult("Hello, My World!");
        //入队操作
        queue.offer(result);
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

    @GetMapping("/callable-hello-world")
    public Callable<String> callableHelloWorld() {
        final long startTime = System.currentTimeMillis();
        println("Hello,world!");
        return () -> {
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello,world!";
        };
    }

    private void println(Object object) {
        String name = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController Name[" + name + "]: " + object);
    }

}
