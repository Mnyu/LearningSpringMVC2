package com.learnjava.frenemy.controller;

import com.learnjava.frenemy.dao.SignupDAO;
import com.learnjava.frenemy.model.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SignupDAO signupDAO;

    @GetMapping("/custom-login")
    public String showLogin() {
        return "custom-login";
    }

    @GetMapping("/signup")
    public String showSignUp(Model model) {
        model.addAttribute("signupDTO", new SignupDTO());
        return "signup";
    }

    @PostMapping("/process-signup")
    public String processSignup(SignupDTO signupDTO) {
        signupDTO.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
        signupDAO.saveUser(signupDTO);
        return "redirect:/custom-login";
    }
}
