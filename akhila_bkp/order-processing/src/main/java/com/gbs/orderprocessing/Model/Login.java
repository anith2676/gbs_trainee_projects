package com.gbs.orderprocessing.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Login {

    @Id
    private Integer id;

    @Column(name = "employee_name")
    private String employeeName;

  
    @Column(nullable = false, name = "contact_number")
    private Integer contactNum;

    
}
