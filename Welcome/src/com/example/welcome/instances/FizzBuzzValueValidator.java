package com.example.welcome.instances;

import com.example.welcome.interfaces.FizzBuzzValidator;

public class FizzBuzzValueValidator implements FizzBuzzValidator {
    @Override
    public boolean isNumber(String value) {
        if (value == null || value.isEmpty())
            return false;
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
