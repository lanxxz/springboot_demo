package com.alien.practice.springboot_demo.service;

/***
 * 计算服务
 * @author Alien
 * @date 2019.03.25
 */
public interface CalculateService {

    /**
     * 求多个values 的和
     * @param values 多个整数
     * @return sum 累加值
     */
    Integer sum(Integer... values);
}
