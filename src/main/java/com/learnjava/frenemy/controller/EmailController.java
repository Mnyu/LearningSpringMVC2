package com.learnjava.frenemy.controller;

import com.learnjava.frenemy.model.EmailDTO;
import com.learnjava.frenemy.model.UserDTO;
import com.learnjava.frenemy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/send-email")
    public String showEmailPage(@ModelAttribute("emailDTO") EmailDTO emailDTO) {
        return "send-email";
    }

    @RequestMapping("/process-email")
    public String processEmail(@SessionAttribute("userDTO") UserDTO userDTO,
                               @ModelAttribute("emailDTO") EmailDTO emailDTO) {
        emailService.sendEmail(userDTO.getUserName(), emailDTO.getUserEmail(), userDTO.getRelation());
        return "process-email";
    }

}
