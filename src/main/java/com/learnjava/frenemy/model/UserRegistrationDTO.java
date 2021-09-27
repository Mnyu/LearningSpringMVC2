package com.learnjava.frenemy.model;

import com.learnjava.frenemy.annotations.CustomAge;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistrationDTO {
    private String name;
    private String userName;
    private char[] password;
    private String country;
    private String[] hobbies;
    private String gender;

    //@CustomAge
    //@CustomAge(lower = 30, upper = 75, message = "* Age min = 30 & max = 75")
    @CustomAge(lower = 30, upper = 75)
    private Integer age;

    private CommunicationDTO communicationDTO;
}
