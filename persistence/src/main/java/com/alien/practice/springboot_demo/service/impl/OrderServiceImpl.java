package com.alien.practice.springboot_demo.service.impl;

import com.alien.practice.springboot_demo.componment.HandlerContext;
import com.alien.practice.springboot_demo.domain.OrderDTO;
import com.alien.practice.springboot_demo.componment.AbstractHandler;
import com.alien.practice.springboot_demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单处理服务层业务具体实现
 *
 * @author Alien
 * @since 2019/4/9 22:22
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDTO dto) {
        AbstractHandler handler = handlerContext.getInstance(dto.getType());
        return handler.handle(dto);
    }
}
