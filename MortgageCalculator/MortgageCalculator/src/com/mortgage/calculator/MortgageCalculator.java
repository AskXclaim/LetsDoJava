package com.mortgage.calculator;

import com.mortgage.calculator.interfaces.Display;
import com.mortgage.calculator.interfaces.Input;
import com.mortgage.calculator.interfaces.InputValidator;
import com.mortgage.calculator.interfaces.StringToFloatConverter;

import java.util.Currency;
import java.util.Locale;

public class MortgageCalculator {


    private final Display display;
    private final Input input;
    private final InputValidator validator;
    private final StringToFloatConverter converter;
    private final Mortgage mortgage;

    public MortgageCalculator(Display display, Input input, InputValidator validator, StringToFloatConverter converter) {
        this.display = display;
        this.input = input;
        this.validator = validator;
        this.converter = converter;
        this.mortgage = new Mortgage();
    }

    public void run() {
        this.display.newLineDisplay("Welcome");
        mortgage.principal = getEntry("Principal: ");
        mortgage.annualInterestRate = getEntry("Annual Interest Rate: ");
        mortgage.period = getEntry("Period (in Years): ");
        this.mortgage.monthlyPayments = Math.round(calculateMortgageMonthlyPayment());
        var currency = Currency.getInstance(Locale.getDefault());
        this.display.newLineDisplay(String.format("Your monthly payment would be about %s%s",
                currency.getSymbol(), this.mortgage.monthlyPayments));
    }

    private float getEntry(String text) {
        do {
            this.display.display(text);
            var entry = this.input.getEntry();
            if (validator.isFloat(entry)) {
                return converter.getFloat(entry);
            }
        } while (true);
    }

    private double calculateMortgageMonthlyPayment() {
        final int Months_IN_A_YEAR = 12;
        var monthlyInterestRate = ((mortgage.annualInterestRate) / 100) / 12;
        var partOfCalculation = Math.pow(1 + monthlyInterestRate, mortgage.period * Months_IN_A_YEAR);
        return mortgage.principal * ((monthlyInterestRate * partOfCalculation) / ((partOfCalculation) - 1));
    }
}
