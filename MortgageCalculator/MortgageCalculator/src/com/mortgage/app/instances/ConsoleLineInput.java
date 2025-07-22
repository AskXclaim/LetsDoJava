package com.mortgage.app.instances;

import com.mortgage.app.interfaces.Display;
import com.mortgage.app.interfaces.Input;

import java.util.Scanner;

public class ConsoleLineInput implements Input {
    private final Scanner scanner;
    private final Display display;

    public ConsoleLineInput(Display display) {
        this.display = display;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public float getEntry() {
        do {
            try {
                var entry = scanner.nextLine().trim();
                return Float.parseFloat(entry);
            } catch (Exception _) {
                display.newLineDisplay("Invalid input, value must be a number");
            }
        } while (true);
    }
}
