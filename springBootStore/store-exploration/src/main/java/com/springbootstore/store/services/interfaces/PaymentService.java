package com.springbootstore.store.services.interfaces;

import com.springbootstore.store.services.models.PaymentResult;

public interface PaymentService {
    PaymentResult makePayment(Double amount);
}
