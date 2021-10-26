package com.learnjava.frenemy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

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

    @GetMapping("/roles")
    public String showRolesLink(Authentication authentication, Principal principal, Model model) {
        System.out.println("==============================");
        System.out.println("LOGGED IN USER : " + authentication.getPrincipal().toString());
        System.out.println("AUTHORITIES : " + authentication.getAuthorities());
        System.out.println("==============================");
        model.addAttribute("username", principal.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "roles";
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin";
    }

    @GetMapping("/user")
    public String showUserPage() {
        return "user";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
