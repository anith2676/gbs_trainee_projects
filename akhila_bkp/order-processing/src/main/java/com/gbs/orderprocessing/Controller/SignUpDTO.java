package com.gbs.orderprocessing.Controller;

import java.util.List;

import com.gbs.orderprocessing.Model.Login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpDTO {

    private Login user;
}
