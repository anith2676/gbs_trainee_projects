package com.gbs.login.loginsignup.service;

import java.util.List;
import java.util.Optional;

import com.gbs.login.loginsignup.model.SignUp;
import com.gbs.login.loginsignup.repository.SignUpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpli implements SignUpService {

    @Autowired
    private SignUpRepository signUpRepository;

    @Override
    public SignUp create(SignUp signUp) {
       
        return signUpRepository.save(signUp );
    }

    @Override
    public List<SignUp> findAll() {
      
        return signUpRepository.findAll();
    }

    @Override
    public SignUp save(SignUp signUp) {
       
        return signUpRepository.save(signUp);
    }

    @Override
    public Optional<SignUp> findById(Integer id) {
       
        return signUpRepository.findById(id);
    }

    @Override
    public List<SignUp> getUserByLogin(String userName, String password) {
        
        return signUpRepository.getUserByLogin(userName, password);
    }

    // @Override
    // public Integer login(String userName, String password) {
    //     SignUp user = signUpRepository.getUserByUserNameAndPassword(userName, password);
    //     if (user == null) return 0;
    //     return user.getId();
    // }

    
}
