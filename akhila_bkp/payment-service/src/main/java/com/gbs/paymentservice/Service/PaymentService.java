package com.gbs.paymentservice.Service;

import com.gbs.paymentservice.Model.Payment;

public interface PaymentService {

    Payment process(Payment payment);
    
}
