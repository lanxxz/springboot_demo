package com.alien.practice.springboot_demo.componment.biz;

import com.alien.practice.springboot_demo.annotation.HandlerType;
import com.alien.practice.springboot_demo.domain.OrderDTO;
import com.alien.practice.springboot_demo.componment.AbstractHandler;
import org.springframework.stereotype.Component;

/**
 * 团购订单
 *
 * @author Alien
 * @since 2019/4/9 22:16
 */
@Component
@HandlerType("2")
public class GroupHandler extends AbstractHandler {
    @Override
    public String handle(OrderDTO dto) {
        return "处理团购订单...";
    }
}
