package com.learnjava.frenemy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneDTO {
    private String countryCode;
    private String number;

    @Override
    public String toString() {
        return countryCode + "-" + number;
    }
}
