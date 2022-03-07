package com.gbs.paymentservice.Service;

import com.gbs.paymentservice.Model.Payment;
import com.gbs.paymentservice.Model.Payment.PaymentStatus;
import com.gbs.paymentservice.Repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment process(Payment payment) {
        payment.setPaymentStatus(PaymentStatus.APPROVED); 
        Payment paymentSaved = paymentRepository.save(payment);
        return paymentSaved;
    

    }

    
    
}
