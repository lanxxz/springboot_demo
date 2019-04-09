package com.alien.practice.springboot_demo.controller;

import com.alien.practice.springboot_demo.domain.OrderDTO;
import com.alien.practice.springboot_demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单前端处理
 *
 * @author Alien
 * @since 2019/4/9 23:40
 */
@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/order")
    public String order() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setType("2");
        return orderService.handle(orderDTO);
    }

}
