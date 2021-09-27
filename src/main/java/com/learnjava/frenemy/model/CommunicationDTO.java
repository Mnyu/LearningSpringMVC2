package com.learnjava.frenemy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommunicationDTO {
    private String email;
    private PhoneDTO phone;

}
