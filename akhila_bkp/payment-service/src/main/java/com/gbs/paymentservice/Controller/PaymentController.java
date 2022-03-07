package com.gbs.paymentservice.Controller;

import java.util.Optional;

import com.gbs.paymentservice.Model.Payment;
import com.gbs.paymentservice.Repository.PaymentRepository;
import com.gbs.paymentservice.Service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/payment")
	public ResponseEntity<Payment> create(@RequestBody  Payment payment) {
		return ResponseEntity.ok(paymentService.process(payment));
	}

    @GetMapping("/payment/{paymentId}")
	public ResponseEntity<Optional<Payment>> getStatusByPaymentId(@PathVariable String id) {
		Optional<Payment> payment = paymentRepository.findById(id);
		return ResponseEntity.ok(payment);
	}
    
}
