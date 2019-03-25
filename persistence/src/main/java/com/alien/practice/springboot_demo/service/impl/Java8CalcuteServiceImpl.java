package com.alien.practice.springboot_demo.service.impl;

import com.alien.practice.springboot_demo.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Java 8 Lambda 实现 {@link CalculateService}
 * @author Alien
 * @date 2019.03.15
 */
@Service
@Profile("Java8")
public class Java8CalcuteServiceImpl implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 8 Lambda 实现");
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }
}
