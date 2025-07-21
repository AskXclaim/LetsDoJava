package com.mortgage.calculator;

import com.mortgage.calculator.interfaces.*;

import java.util.Currency;
import java.util.Locale;

public class MortgageCalculator implements Application {
    static final int MONTHS_IN_A_YEAR = 12;
    private final Display display;
    private final Input input;
    private final InputValidator validator;
    private final StringToFloatConverter converter;

    public MortgageCalculator(Display display, Input input, InputValidator validator, StringToFloatConverter converter) {
        this.display = display;
        this.input = input;
        this.validator = validator;
        this.converter = converter;
    }

    public void run() {
        this.display.newLineDisplay("Welcome");
        var currency = Currency.getInstance(Locale.getDefault());
        float principal = getEntry("Principal (" + currency.getSymbol() + "1K - " + currency.getSymbol() + "1M): "
                , "Principal", 1_000, 1_000_000, true);
        float annualInterestRate = getEntry("Annual Interest Rate: ",
                "Annual interest rate", 0.1F, 12.5F, false);
        var mortgagePeriod = getEntry("Period (in Years): ", "Period (in Years)", 1, 35, true);
        float monthlyPayments = Math.round(calculateMortgageMonthlyPayment(principal, annualInterestRate, mortgagePeriod));
        displayMortgageSection(monthlyPayments);
        displayPaymentSchedule(principal, annualInterestRate, mortgagePeriod);
    }


    private float getEntry(String text, String invalidText, float lowerLimit, float upperLimit, boolean shouldDisplayAsInteger) {
        do {
            this.display.display(text);
            var entry = this.input.getEntry();
            if (!validator.isFloat(entry)) {
                showInvalidValueMessage(invalidText, lowerLimit, upperLimit, shouldDisplayAsInteger);
                continue;
            }
            var convertedValue = converter.getFloat(entry);
            if (convertedValue >= lowerLimit && convertedValue <= upperLimit)
                return convertedValue;

            showInvalidValueMessage(invalidText, lowerLimit, upperLimit, shouldDisplayAsInteger);
        } while (true);
    }

    private void showInvalidValueMessage(String invalidText, float lowerLimit, float upperLimit, boolean shouldDisplayAsInteger) {
        this.display.newLineDisplay(invalidText + " needs to be a number between "
                + getValue(lowerLimit, shouldDisplayAsInteger) + " and " +
                getValue(upperLimit, shouldDisplayAsInteger) + " please provide a valid " + invalidText);
    }

    private String getValue(float value, boolean shouldDisplayAsInteger) {
        return "" + (shouldDisplayAsInteger ? Integer.toString(Math.round(value)) : value);
    }

    private double calculateMortgageMonthlyPayment(float principal, float annualInterestRate, float mortgagePeriod) {
        var monthlyInterestRate = getMonthlyInterest(annualInterestRate);
        var partOfCalculation = Math.pow((1 + monthlyInterestRate), mortgagePeriod * MONTHS_IN_A_YEAR);
        return principal * ((monthlyInterestRate * partOfCalculation) / ((partOfCalculation) - 1));
    }

    private float getMonthlyInterest(float annualInterestRate) {
        final int PERCENT = 100;
        return (annualInterestRate / PERCENT) / MONTHS_IN_A_YEAR;
    }

    private void displayMortgageSection(float monthlyPayments) {
        this.display.displayHeader("MORTGAGE", '—');
        this.display.displayMoney("Monthly payments:", monthlyPayments);
    }

    private void displayPaymentSchedule(float principal, float annualInterestRate, float mortgagePeriod) {
        this.display.displayHeader("PAYMENT SCHEDULE", '—');
        var totalPaymentsToMake = Math.round(mortgagePeriod * MONTHS_IN_A_YEAR);
        double currentBalance;
        for (var paymentsMade = 1; paymentsMade <= totalPaymentsToMake; paymentsMade++) {
            currentBalance = getMortgageBalance(principal, annualInterestRate, totalPaymentsToMake, paymentsMade);
            this.display.displayMoney("", currentBalance);
        }
    }

    private double getMortgageBalance(float principal, float annualInterestRate, int numberOfPayments, int paymentsMade) {
        var monthlyInterestRatePlusOne = 1 + getMonthlyInterest(annualInterestRate);
        var currentBalanceCalTopPart = principal * ((Math.pow(monthlyInterestRatePlusOne, numberOfPayments))
                - (Math.pow(monthlyInterestRatePlusOne, paymentsMade)));
        var currentBalanceCalBottomPart = (Math.pow(monthlyInterestRatePlusOne, numberOfPayments)) - 1;
        return currentBalanceCalTopPart / currentBalanceCalBottomPart;
    }
}
