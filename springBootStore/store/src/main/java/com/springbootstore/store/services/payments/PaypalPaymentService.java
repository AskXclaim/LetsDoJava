package com.springbootstore.store.services.payments;

import com.springbootstore.store.services.interfaces.PaymentService;
import com.springbootstore.store.services.models.PaymentResult;

import static java.lang.System.out;

public class PaypalPaymentService implements PaymentService {
    @Override
    public PaymentResult makePayment(Double amount) {
        out.printf("Payment via Paypal of : %s%n", amount);
        return new PaymentResult(true);
    }
}
