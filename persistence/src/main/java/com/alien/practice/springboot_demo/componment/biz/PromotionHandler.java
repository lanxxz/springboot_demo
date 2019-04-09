package com.alien.practice.springboot_demo.componment.biz;

import com.alien.practice.springboot_demo.annotation.HandlerType;
import com.alien.practice.springboot_demo.domain.OrderDTO;
import com.alien.practice.springboot_demo.componment.AbstractHandler;
import org.springframework.stereotype.Component;

/**
 * 促销订单
 *
 * @author Alien
 * @since 2019/4/9 22:18
 */
@Component
@HandlerType("3")
public class PromotionHandler extends AbstractHandler {
    @Override
    public String handle(OrderDTO dto) {
        return "处理促销订单";
    }
}
