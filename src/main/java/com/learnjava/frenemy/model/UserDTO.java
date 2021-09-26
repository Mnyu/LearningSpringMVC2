package com.learnjava.frenemy.model;

import lombok.Data;

@Data
public class UserDTO {
    private String userName = "default user name";
    private String friendName = "default friend name";

    public UserDTO() {
        System.out.println("*******************");
        System.out.println("UserDTO constructor called...");
        System.out.println("*******************");
    }

}
