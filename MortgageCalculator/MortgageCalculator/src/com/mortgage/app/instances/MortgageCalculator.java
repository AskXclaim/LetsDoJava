package com.mortgage.app.instances;

import java.util.Currency;
import java.util.Locale;

public class MortgageCalculator implements com.mortgage.app.interfaces.MortgageCalculator {
    static final int MONTHS_IN_A_YEAR = 12;
    private final String currencySymbol;
    private final int totalPaymentsToMake;
    private float principal;
    private float annualInterestRate;
    private byte mortgagePeriod;

    public MortgageCalculator(float principal, float annualInterestRate, float mortgagePeriod) {
        this.currencySymbol = Currency.getInstance(Locale.getDefault()).getSymbol();
        setPrincipal(principal);
        setAnnualInterestRate(annualInterestRate);
        setMortgagePeriod(mortgagePeriod);
        this.totalPaymentsToMake = this.mortgagePeriod * MONTHS_IN_A_YEAR;
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

    public int getTotalPaymentsToMake() {
        return totalPaymentsToMake;
    }

    public double calculateMortgage() {
        var monthlyInterestRate = getMonthlyInterest(annualInterestRate);
        var partOfCalculation = Math.pow((1 + monthlyInterestRate), mortgagePeriod * MONTHS_IN_A_YEAR);
        return principal * ((monthlyInterestRate * partOfCalculation) / ((partOfCalculation) - 1));
    }

    public double getMortgageBalance(byte numberOfPaymentsMade) {
        var monthlyInterestRatePlusOne = 1 + getMonthlyInterest(annualInterestRate);
        var currentBalanceCalTopPart = principal * ((Math.pow(monthlyInterestRatePlusOne, totalPaymentsToMake))
                - (Math.pow(monthlyInterestRatePlusOne, numberOfPaymentsMade)));
        var currentBalanceCalBottomPart = (Math.pow(monthlyInterestRatePlusOne, totalPaymentsToMake)) - 1;
        return currentBalanceCalTopPart / currentBalanceCalBottomPart;
    }

    private float getMonthlyInterest(float annualInterestRate) {
        final int PERCENT = 100;
        return (annualInterestRate / PERCENT) / MONTHS_IN_A_YEAR;
    }
}
