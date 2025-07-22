package com.mortgage.app.interfaces;

public interface MortgageCalculator {
    double calculateMortgage();

    int getTotalPaymentsToMake();

    double getMortgageBalance(byte numberOfPaymentsMade);
}
