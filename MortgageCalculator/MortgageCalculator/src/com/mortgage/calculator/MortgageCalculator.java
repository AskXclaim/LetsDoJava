package com.mortgage.calculator;

import com.mortgage.calculator.interfaces.*;

import java.util.Currency;
import java.util.Locale;

public class MortgageCalculator implements Application {


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
        mortgage.principal = getEntry("Principal: ",
                "Principal needs to be a number, please provide a valid principal amount.");
        mortgage.annualInterestRate = getEntry("Annual Interest Rate: ",
                "Annual interest rate needs to be a number, please provide a valid annual interest rate amount.");
        mortgage.period = getEntry("Period (in Years): ",
                "Period needs to be a number, please provide a valid period.");
        this.mortgage.monthlyPayments = Math.round(calculateMortgageMonthlyPayment());
        var currency = Currency.getInstance(Locale.getDefault());
        this.display.newLineDisplay(String.format("Your monthly payment would be about %s%s",
                currency.getSymbol(), this.mortgage.monthlyPayments));
    }

    private float getEntry(String text, String invalidText) {
        do {
            this.display.display(text);
            var entry = this.input.getEntry();
            if (validator.isFloat(entry)) {
                return converter.getFloat(entry);
            } else {
                this.display.newLineDisplay(invalidText);
            }
        } while (true);
    }

    private double calculateMortgageMonthlyPayment() {
        final int Months_IN_A_YEAR = 12;
        var monthlyInterestRate = ((mortgage.annualInterestRate) / 100) / Months_IN_A_YEAR;
        var partOfCalculation = Math.pow(1 + monthlyInterestRate, mortgage.period * Months_IN_A_YEAR);
        return mortgage.principal * ((monthlyInterestRate * partOfCalculation) / ((partOfCalculation) - 1));
    }
}
