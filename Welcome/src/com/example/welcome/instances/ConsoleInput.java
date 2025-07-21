package com.example.welcome.instances;

import com.example.welcome.interfaces.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private final Scanner scanner;

    public ConsoleInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
