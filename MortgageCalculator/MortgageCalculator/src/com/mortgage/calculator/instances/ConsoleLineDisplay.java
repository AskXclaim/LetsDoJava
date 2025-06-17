package com.mortgage.calculator.instances;

import com.mortgage.calculator.interfaces.Display;

import static java.lang.System.*;

public class ConsoleLineDisplay implements Display {
    @Override
    public void display(String content) {
        out.print(content);
    }

    @Override
    public void newLineDisplay(String content) {
        out.println(content);
    }
}
