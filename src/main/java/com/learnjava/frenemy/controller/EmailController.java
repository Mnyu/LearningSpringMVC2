package com.learnjava.frenemy.controller;

import com.learnjava.frenemy.model.EmailDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {

    @RequestMapping("/send-email")
    public String showEmailPage(@ModelAttribute("emailDTO") EmailDTO emailDTO) {
        return "send-email";
    }

    @RequestMapping("/process-email")
    public String showProcessEmailPage(@ModelAttribute("emailDTO") EmailDTO emailDTO) {
        return "process-email";
    }

}
