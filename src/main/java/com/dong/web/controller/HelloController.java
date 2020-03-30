package com.dong.web.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World
 * @Author 3hld
 * @Date 2019/12/9 9:45
 * @Version 1.0
 */
@Api(tags = "测试")
@RestController("hello")
@RequestMapping("/hello")
public class HelloController {


    @GetMapping(value = "/hello")
    public String hello(){
        return "/hello";
    }

    @PostMapping(value = "hi")
    public String hi(){
        return "hi world!";
    }
}
