package com.learnjava.frenemy.model;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @NotBlank(message = "* Name can not be blank")
    @Size(min = 3, max = 15, message = "* Name should have min 3 and max 15 characters")
    private String userName;

    @NotBlank(message = "* Friend name can not be blank")
    @Size(min = 3, max = 15, message = "* Friend name should have min 3 and max 15 characters")
    private String friendName;

    @AssertTrue(message = "* You have to agree to terms and conditions.")
    private boolean termsAndConditionsAccepted;

    private String relation;

    public UserDTO() {
        System.out.println("*******************");
        System.out.println("UserDTO constructor called...");
        System.out.println("*******************");
    }

}
