package com.mortgage.app.instances;

import com.mortgage.app.interfaces.*;

import java.util.Currency;
import java.util.Locale;

public class MortgageApp implements Application {
    private final Display display;
    private final Input input;

    public MortgageApp(Display display, Input input) {
        this.display = display;
        this.input = input;
    }

    @Override
    public void run() {
        display.newLineDisplay("Welcome");
        var currencySymbol = Currency.getInstance(Locale.getDefault()).getSymbol();
        display.display("Principal (" + currencySymbol + "1K - " + currencySymbol + "1M): ");
        float principal = getEntry(1_000, 1_000_000, "Principal", true);
        display.display("Annual Interest Rate: ");
        float annualInterestRate = getEntry(0F, 12F, "annual interest rate", false);
        display.display("Period (in Years): ");
        var mortgagePeriod = getEntry(1, 35, "mortgage period", true);
        var mortgageCalculator = new MortgageCalculator(principal, annualInterestRate, mortgagePeriod);
        var mortgageReport = new MortgageReport(display, mortgageCalculator);
        mortgageReport.displayMortgageSection();
        mortgageReport.displayPaymentSchedule();
    }

    private float getEntry(float lowerLimit, float upperLimit, String itemName, boolean shouldDisplayAsInteger) {
        do {
            var value = input.getEntry();
            if (value < lowerLimit || value > upperLimit) {
                showInvalidValueMessage(itemName, lowerLimit, upperLimit, shouldDisplayAsInteger);
                continue;
            }
            return value;
        } while (true);
    }

    private void showInvalidValueMessage(String itemName, float lowerLimit, float upperLimit, boolean shouldDisplayAsInteger) {
        display.newLineDisplay(itemName + " needs to be a number between "
                + getValue(lowerLimit, shouldDisplayAsInteger) + " and " +
                getValue(upperLimit, shouldDisplayAsInteger) + " please provide a valid " + itemName);
    }

    private String getValue(float value, boolean shouldDisplayAsInteger) {
        return "" + (shouldDisplayAsInteger ? Integer.toString(Math.round(value)) : value);
    }
}
