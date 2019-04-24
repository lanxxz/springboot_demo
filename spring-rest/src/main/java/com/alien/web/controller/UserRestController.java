package com.alien.web.controller;

import com.alien.web.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User {@link RestController}
 *
 * @author Alien
 * @since 2019/4/22 22:48
 */
@RestController
public class UserRestController {

    @PostMapping("/echo/user")
    public User user(@RequestBody User user) {
        return user;
    }
}
