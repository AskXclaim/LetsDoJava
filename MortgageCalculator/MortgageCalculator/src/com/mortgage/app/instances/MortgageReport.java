package com.mortgage.app.instances;

import com.mortgage.app.interfaces.MortgageCalculator;
import com.mortgage.app.interfaces.Display;

public class MortgageReport {

    private final Display display;
    private final MortgageCalculator mortgageCalculator;

    public MortgageReport(Display display, MortgageCalculator mortgageCalculator) {
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
        double currentBalance;
        for (byte paymentsMade = 1;
             paymentsMade <= mortgageCalculator.getTotalPaymentsToMake(); paymentsMade++) {
            currentBalance = mortgageCalculator.getMortgageBalance(paymentsMade);
            display.displayMoney("", currentBalance);
        }
    }
}
