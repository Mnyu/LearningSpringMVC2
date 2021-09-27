package com.learnjava.frenemy.fornatter;

import com.learnjava.frenemy.model.PhoneDTO;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;


public class PhoneNumberFormatter implements Formatter<PhoneDTO> {

    @Override
    public PhoneDTO parse(String s, Locale locale) throws ParseException {
        String[] phoneArr = s.split("-");
        String countryCode = "91";
        String number = phoneArr[0];
        if (phoneArr.length == 2) {
            countryCode = phoneArr[0];
            number = phoneArr[1];
        }
        return PhoneDTO.builder()
                .countryCode(countryCode)
                .number(number)
                .build();
    }

    @Override
    public String print(PhoneDTO phoneDTO, Locale locale) {
        return phoneDTO.getCountryCode() + "-" + phoneDTO.getNumber();
    }
}
