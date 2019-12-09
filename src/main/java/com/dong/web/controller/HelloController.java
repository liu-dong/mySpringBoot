package com.dong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello World
 * @Author 3hld
 * @Date 2019/12/9 9:45
 * @Version 1.0
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "hello")
    public String hello(){
        return "/hello";
    }

    @RequestMapping(value = "hi")
    @ResponseBody
    public String hi(){
        return "hi world!";
    }
}
