package com.learnjava.frenemy.propertyeditor;

import java.beans.PropertyEditorSupport;

public class CustomNamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String convertedString = text.toUpperCase();
        setValue(convertedString);
    }

    @Override
    public String getAsText() {
        // custom logic should be written here for initial display.
        return super.getAsText();
    }
}
