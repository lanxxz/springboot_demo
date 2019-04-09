package com.alien.practice.springboot_demo.domain;

import java.math.BigDecimal;

/**
 * 订单类
 *
 * @author Alien
 * @since 2019/4/9 21:35
 */
public class OrderDTO {

    /**
     * 编码
     */
    private String code;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 订单类型：
     * 1、普通订单
     * 2、团购订单
     * 3、促销订单
     */
    private String type;

    public String getCode() {
        return code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }
}
