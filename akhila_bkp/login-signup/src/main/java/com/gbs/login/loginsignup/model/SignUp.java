package com.gbs.login.loginsignup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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

public class SignUp {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "employee_name" )
    private String employeeName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false , name = "contact_number")
    private Integer contactNum;

    @Column(nullable = false , name = "address")
    private String address;

    @Column(name = "user_name")
    private String userName;

    @Column(nullable = false)
    private String password;
    
}
