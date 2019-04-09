package com.alien.practice.springboot_demo.service;

import com.alien.practice.springboot_demo.domain.OrderDTO;

/**
 * 订单处理服务层业务
 *
 * @author Alien
 * @since 2019/4/9 22:20
 */
public interface IOrderService {

    String handle(OrderDTO dto);
}
