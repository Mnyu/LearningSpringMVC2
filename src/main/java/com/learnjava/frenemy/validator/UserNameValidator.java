package com.learnjava.frenemy.validator;

import com.learnjava.frenemy.model.UserRegistrationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserNameValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        // checks if this validator is supported for the object/class in question
        return UserRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        // Custom Validation logic here

        // Validation 1 : Empty or White Spaces --- INBUILT
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty",
                "* Username can not be empty");


        // Validation 2 : UseName should have _ --- CUSTOM
        UserRegistrationDTO userRegistrationDTO = (UserRegistrationDTO) o;
        String userName = userRegistrationDTO.getUserName();
        if (!userName.contains("_")) {
            errors.rejectValue("userName", "userName.invalid", "* Username should contain _");
        }
    }
}
