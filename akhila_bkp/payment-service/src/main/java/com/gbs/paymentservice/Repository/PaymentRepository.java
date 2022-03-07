package com.gbs.paymentservice.Repository;

import com.gbs.paymentservice.Model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,String> {
    
}
