package com.alien.web.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.Controller;

import java.util.Properties;

/**
 * {@link Properties} {@link Controller}
 *
 * @author Alien
 * @since 2019/4/24 23:29
 */
@RestController
public class PropertiesRestController {

    @PostMapping(value = "/add/props",
        // Content-Type 过滤媒体类型
        consumes = "text/properties;charset=UTF-8"
    )
    public String addProperties(@RequestBody Properties properties) {
        StringBuilder sb = new StringBuilder();
        sb.append("id is ").append(properties.get("id"))
                .append("; name is ").append(properties.get("name"))
                .append(".");
        return sb.toString();
    }

    @PostMapping(value = "add/properties",
            consumes = "text/properties;charset=UTF-8"
//            ,produces = "text/properties;charset=UTF-8"
    )
    public Properties returnProp(@RequestBody Properties properties) {
        return properties;
    }

}
