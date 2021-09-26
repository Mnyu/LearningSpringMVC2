package com.learnjava.frenemy.model;

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
}
