package com.mortgage.calculator.instances;

import com.mortgage.calculator.interfaces.InputValidator;

public class ConsoleLineInputValidator implements InputValidator {
    @Override
    public boolean isFloat(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
