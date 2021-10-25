package com.learnjava.frenemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/custom-login")
    public String showLogin() {
        return "custom-login";
    }
}
