package com.alien.practice.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 异步 实现 {@link HttpServlet}
 *
 * @author Alien
 * @since 2019/5/22 23:44
 */
@WebServlet(
        urlPatterns = "/async-servlet", //映射路径
        name = "asyncServlet", // Servlet 名字
        asyncSupported = true // 开启异步支持
)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.isAsyncSupported()) {
            AsyncContext asyncContext = req.startAsync();
            // 设置超时时间
            asyncContext.setTimeout(50L);
            // 设置监听器
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent asyncEvent) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent asyncEvent) throws IOException {
                    println("执行超时");
                }

                @Override
                public void onError(AsyncEvent asyncEvent) throws IOException {
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
                    println("开始执行");
                }
            });

            println("main线程");
            ServletResponse response = asyncContext.getResponse();
            response.setContentType("text/plain;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println("你好，世界！");
            writer.flush();
        }
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("AsyncServlet[" + threadName + "]: " + object);
    }
}
