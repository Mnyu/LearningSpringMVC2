package com.learnjava.frenemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String userName, String email, String result) {
        SimpleMailMessage newEmail = new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject("FRENEMY APP RESULT");
        newEmail.setText("Hi " + userName + "! The result predicted ny Frenemy App is : " + result);

        javaMailSender.send(newEmail);
    }
}
