package com.mortgage.calculator.instances;

import com.mortgage.calculator.interfaces.StringToFloatConverter;

public class ConsoleLineConverter implements StringToFloatConverter {
    @Override
    public float getFloat(String value) {
        return Float.parseFloat(value);
    }
}
