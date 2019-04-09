package com.alien.practice.springboot_demo.annotation;

import java.lang.annotation.*;

/**
 * 用于标识该处理器对应哪个订单类型<br/>
 * {@link Inherited} 修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。
 * @author Alien
 * @since 2019/4/9 21:43
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {

    String value();
}
