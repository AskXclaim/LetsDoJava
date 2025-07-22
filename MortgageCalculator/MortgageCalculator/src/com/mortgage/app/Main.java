package com.mortgage.app;

import com.mortgage.app.instances.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var display =  new ConsoleLineDisplay();
        var mortgageApp = new MortgageApp(display, new ConsoleLineInput(display));
        mortgageApp.run();
    }
}