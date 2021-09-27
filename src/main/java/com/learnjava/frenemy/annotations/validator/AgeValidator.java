package com.learnjava.frenemy.annotations.validator;

import com.learnjava.frenemy.annotations.CustomAge;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<CustomAge, Integer> {

    private int lower;
    private int upper;

    @Override
    public void initialize(CustomAge customAge) {
        // Method for some post-construct initializations.
        this.lower = customAge.lower();
        this.upper = customAge.upper();

        // THIS METHOD IS CALLED ONLY ONCE WHEN WE REQUEST FOR THE FIRST TIME
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer != null && integer >= lower && integer <= upper;
    }
}
