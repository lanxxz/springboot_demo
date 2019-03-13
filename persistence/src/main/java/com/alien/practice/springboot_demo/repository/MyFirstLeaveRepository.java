package com.alien.practice.springboot_demo.repository;

import com.alien.practice.springboot_demo.annotation.FirstLeaveRepository;
import com.alien.practice.springboot_demo.annotation.SecondLeaveRepository;

//@FirstLeaveRepository(value = "myFirstLeaveRepository")

@SecondLeaveRepository(value = "myFirstLeaveRepository")
public class MyFirstLeaveRepository {

}
