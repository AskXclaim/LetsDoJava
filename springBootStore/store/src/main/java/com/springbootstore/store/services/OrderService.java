package com.springbootstore.store.services;

import com.springbootstore.store.services.interfaces.PaymentService;

import static java.lang.System.*;

public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(double amount) {
        var result = paymentService.makePayment(amount);
        if (result.isPaymentSuccessful()) {
            out.println("Order placed successfully");
        }
    }
}
