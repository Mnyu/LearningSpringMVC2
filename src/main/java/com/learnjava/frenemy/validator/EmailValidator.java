package com.learnjava.frenemy.validator;

import com.learnjava.frenemy.model.UserRegistrationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmailValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        // checks if this validator is supported for the object/class in question
        return UserRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // Custom Validation logic here

        // Validation 1 : Empty or white spaces
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty",
                "*Email can not be empty");

        // Validation 2 : only gmail.com domains allowed
        UserRegistrationDTO userRegistrationDTO = (UserRegistrationDTO) o;
        String email = userRegistrationDTO.getCommunicationDTO().getEmail();
        if (!email.endsWith("@gmail.com")) {
           errors.rejectValue("communicationDTO.email", "email.invalid", "*Only gmail.com domains are allowed");
        }
    }
}
