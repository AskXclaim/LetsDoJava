package com.springbootstore.store.services.models;

public class PaymentResult {
    private final boolean isSuccessful;

    public PaymentResult(boolean isSuccessful){
        this.isSuccessful = isSuccessful;
    }
    public boolean isPaymentSuccessful() {
        return isSuccessful;
    }
}
