package com.learnjava.frenemy.controller;

import com.learnjava.frenemy.model.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @RequestMapping("/register")
    public String showRegistrationPage(@ModelAttribute("userRegDTO") UserRegistrationDTO userRegistrationDTO) {
        return "register";
    }

    @RequestMapping("registration-success")
    public String showRegisterSuccess(@Valid @ModelAttribute("userRegDTO") UserRegistrationDTO userRegistrationDTO,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("***** ERRORS ****** ");
            bindingResult.getAllErrors().forEach(System.out::println);

            return "register";
        }
        return "register-success";
    }

}
