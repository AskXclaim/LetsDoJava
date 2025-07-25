package com.mortgage.app.instances;

import com.mortgage.app.interfaces.Calculator;

import java.util.Currency;
import java.util.Locale;

public class MortgageCalculator implements Calculator {
    static final int MONTHS_IN_A_YEAR = 12;
    private final String currencySymbol;
    private float principal;
    private float annualInterestRate;
    private byte mortgagePeriod;

    public MortgageCalculator(float principal, float annualInterestRate, float mortgagePeriod) {
        this.currencySymbol = Currency.getInstance(Locale.getDefault()).getSymbol();
        setPrincipal(principal);
        setAnnualInterestRate(annualInterestRate);
        setMortgagePeriod(mortgagePeriod);
    }

    public double calculateMortgage() {
        var monthlyInterestRate = getMonthlyInterest(annualInterestRate);
        var partOfCalculation = Math.pow((1 + monthlyInterestRate), mortgagePeriod * MONTHS_IN_A_YEAR);
        return principal * ((monthlyInterestRate * partOfCalculation) / ((partOfCalculation) - 1));
    }

    public double[] getRemainingBalances() {
        double[] mortgageBalances = new double[getTotalPaymentsToMake()];
        for (byte paymentsMade = 1; paymentsMade <= mortgageBalances.length; paymentsMade++)
            mortgageBalances[paymentsMade - 1] = getMortgageBalance(paymentsMade);

        return mortgageBalances;
    }

    public double getMortgageBalance(byte numberOfPaymentsMade) {
        var monthlyInterestRatePlusOne = 1 + getMonthlyInterest(annualInterestRate);
        var currentBalanceCalTopPart = principal * ((Math.pow(monthlyInterestRatePlusOne, getTotalPaymentsToMake()))
                - (Math.pow(monthlyInterestRatePlusOne, numberOfPaymentsMade)));
        var currentBalanceCalBottomPart = (Math.pow(monthlyInterestRatePlusOne, getTotalPaymentsToMake())) - 1;
        return currentBalanceCalTopPart / currentBalanceCalBottomPart;
    }

    private float getMonthlyInterest(float annualInterestRate) {
        final int PERCENT = 100;
        return (annualInterestRate / PERCENT) / MONTHS_IN_A_YEAR;
    }

    private void setPrincipal(float principal) {
        if (principal >= 1_000 && principal <= 1_000_000)
            this.principal = principal;
        else
            throw new IllegalArgumentException(String.format("Principal must be between %s%s and %s%s",
                    this.currencySymbol, getFormattedAmount(0F), this.currencySymbol, getFormattedAmount(1_000_000F)));
    }

    private void setAnnualInterestRate(float annualInterestRate) {
        if (annualInterestRate > 0 && annualInterestRate <= 12)
            this.annualInterestRate = annualInterestRate;
        else
            throw new IllegalArgumentException(String.format("Annual interest rate must be between %s and %s",
                    getFormattedAmount(0F), getFormattedAmount(12F)));
    }

    private void setMortgagePeriod(float mortgagePeriod) {
        if (mortgagePeriod > 1 && mortgagePeriod <= 35)
            this.mortgagePeriod = (byte) mortgagePeriod;
        else
            throw new IllegalArgumentException(String.format("Mortgage period must be between %s and %s",
                    getFormattedAmount(0F), getFormattedAmount(12F)));
    }

    private String getFormattedAmount(float amount) {
        return String.format("%.2f", amount);
    }

    private int getTotalPaymentsToMake() {
        return mortgagePeriod * MONTHS_IN_A_YEAR;
    }
}
