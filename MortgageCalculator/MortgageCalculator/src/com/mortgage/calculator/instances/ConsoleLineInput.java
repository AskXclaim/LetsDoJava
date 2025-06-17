package com.mortgage.calculator.instances;

import com.mortgage.calculator.interfaces.Input;

import java.util.Scanner;

public class ConsoleLineInput implements Input {
    private final Scanner _scanner;

    public ConsoleLineInput(){
        this._scanner= new Scanner(System.in);
    }
    @Override
    public String getEntry() {
        return this._scanner.nextLine();
    }
}
