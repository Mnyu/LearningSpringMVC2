package com.learnjava.frenemy.controller;

import com.learnjava.frenemy.model.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping("/register")
    public String showRegistrationPage(@ModelAttribute("userRegDTO") UserRegistrationDTO userRegistrationDTO) {
        return "register";
    }

    @RequestMapping("registration-success")
    public String showRegisterSuccess(@ModelAttribute("userRegDTO") UserRegistrationDTO userRegistrationDTO) {
        return "register-success";
    }

}
