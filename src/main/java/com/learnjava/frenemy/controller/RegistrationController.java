package com.learnjava.frenemy.controller;

import com.learnjava.frenemy.model.UserRegistrationDTO;
import com.learnjava.frenemy.propertyeditor.CustomNamePropertyEditor;
import com.learnjava.frenemy.validator.EmailValidator;
import com.learnjava.frenemy.validator.UserNameValidator;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // THIS METHOD IS CALLED BEFORE EACH ENDPOINT METHOD OF THIS CONTROLLER
        System.out.println("********** INIT METHOD OF REGISTRATION CONTROLLER CALLED **********");

        // USE OF INIT BINDER - CAN BE USED FOR SOME PRE-PROCESSING BEFORE DATA BINDING
        // webDataBinder.setDisallowedFields("name");

        // USING IN-BUILT PROPERTY EDITOR
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, "name", editor);

        // THINGS THAT CAN BE USED AND REGISTERED USING WEB DATA BINDER :
        // CUSTOM EDITORS, VALIDATORS, REQUIRED PROPERTIES,
        // ALLOWED/DISALLOWED PROPERTIES

        // CUSTOM NAME PROPERTY EDITOR
        CustomNamePropertyEditor customNamePropertyEditor = new CustomNamePropertyEditor();
        webDataBinder.registerCustomEditor(String.class, "name", customNamePropertyEditor);

        // CUSTOM USER NAME VALIDATOR
        webDataBinder.addValidators(new UserNameValidator());
        // CUSTOM EMAIL VALIDATOR
        webDataBinder.addValidators(new EmailValidator());
    }
}
