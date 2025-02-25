package com.gfg.first;

import java.beans.PropertyEditorSupport;

public class FirstNamePropertyEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        setValue(text.trim().toLowerCase());
    }
}
