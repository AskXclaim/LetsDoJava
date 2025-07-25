package com.mortgage.app.instances;

import com.mortgage.app.interfaces.Calculator;
import com.mortgage.app.interfaces.Display;

public class MortgageReport {

    private final Display display;
    private final Calculator mortgageCalculator;

    public MortgageReport(Display display, Calculator mortgageCalculator) {
        this.display = display;
        this.mortgageCalculator = mortgageCalculator;
    }

    public void displayMortgageSection() {
        display.displayHeader("MORTGAGE", '—');
        display.displayMoney("Monthly payments:",
                Math.round(mortgageCalculator.calculateMortgage()));
    }

    public void displayPaymentSchedule() {
        display.displayHeader("PAYMENT SCHEDULE", '—');
        for (double balance : mortgageCalculator.getRemainingBalances())
            display.displayMoney("", balance);
    }
}
