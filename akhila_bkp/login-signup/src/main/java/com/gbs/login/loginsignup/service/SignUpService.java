package com.gbs.login.loginsignup.service;

import java.util.List;
import java.util.Optional;

import com.gbs.login.loginsignup.model.SignUp;

public interface SignUpService {

    SignUp create(SignUp signUp);
 
    Optional <SignUp> findById(Integer id);

    List <SignUp> findAll();

    SignUp save(SignUp signUp);
      
    

    List<SignUp> getUserByLogin(String userName, String password);
    
    
}
