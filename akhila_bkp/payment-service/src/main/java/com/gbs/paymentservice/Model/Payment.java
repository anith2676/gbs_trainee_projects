package com.gbs.paymentservice.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "paymentDate")
    private LocalDate PaymentDate;
    
    @Column(name = "CardType")
    private String CardType;

    @Column(name = "CardNumber")
    private Integer CardNumber;

    public enum PaymentStatus {
		APPROVED;
	}
    @Column(name = "PaymentStatus")
    private PaymentStatus PaymentStatus; 



    
}
