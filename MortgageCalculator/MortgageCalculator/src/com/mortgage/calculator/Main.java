package com.mortgage.calculator;

import com.mortgage.calculator.instances.ConsoleLineDisplay;
import com.mortgage.calculator.instances.ConsoleLineInput;
import com.mortgage.calculator.instances.ConsoleLineInputValidator;
import com.mortgage.calculator.instances.ConsoleLineConverter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var mortgageCalculator = new MortgageCalculator(
                new ConsoleLineDisplay(), new ConsoleLineInput(),
                new ConsoleLineInputValidator(), new ConsoleLineConverter());
        mortgageCalculator.run();
    }
}