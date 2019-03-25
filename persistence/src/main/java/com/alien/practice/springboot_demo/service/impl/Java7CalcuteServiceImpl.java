package com.alien.practice.springboot_demo.service.impl;

import com.alien.practice.springboot_demo.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Java 7 for 循环实现 {@link CalculateService}
 * @author Alien
 * @date 2019.03.15
 */
@Service
@Profile("Java7")
public class Java7CalcuteServiceImpl implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 7 for 循环实现");
        int sum = 0;

        for (int value: values) {
            sum += value;
        }

        return sum;
    }
}
