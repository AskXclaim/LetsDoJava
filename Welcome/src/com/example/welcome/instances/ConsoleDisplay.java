package com.example.welcome.instances;

import com.example.welcome.interfaces.Display;

import static java.lang.System.out;

public class ConsoleDisplay implements Display {
    @Override
    public void show(String value) {
        out.print(value);
    }

    @Override
    public void showOnNewLine(String value) {
        out.println(value);
    }
}
