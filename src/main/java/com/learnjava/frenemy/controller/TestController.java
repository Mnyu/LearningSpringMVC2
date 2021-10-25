package com.learnjava.frenemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @ResponseBody
    @GetMapping("/test")
    public String sayHello() {
        return "TEST!!!";
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "HELLO!!!";
    }

    @ResponseBody
    @GetMapping("/bye")
    public String bye() {
        return "BYE!!!";
    }
}
