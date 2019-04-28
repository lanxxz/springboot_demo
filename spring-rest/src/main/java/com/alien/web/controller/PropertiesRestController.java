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


    /**
     * 1. {@link RequestBody}注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，
     * 比如说：application/json或者是application/xml等。一般情况下来说常用其来处理application/json类型<br/>
     * 2. 通过{@link RequestBody}可以将请求体中的JSON字符串绑定到相应的bean上，
     * 当然，也可以将其分别绑定到对应的字符串上
     */
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

    @PostMapping(value = "add/properties2",
            consumes = "text/properties;charset=UTF-8"
//            ,produces = "text/properties;charset=UTF-8"
    )
    public Properties returnProp2(Properties properties) {
        return properties;
    }

}
