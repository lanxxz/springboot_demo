package com.alien.practice.springboot_demo.componment;

import com.alien.practice.springboot_demo.domain.OrderDTO;

/**
 * 具体业务的抽象父类
 *
 * @author Alien
 * @since 2019/4/9 21:50
 */
public abstract class AbstractHandler {

    abstract public String handle(OrderDTO dto);
}
