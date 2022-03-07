package com.gbs.login.loginsignup.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gbs.login.loginsignup.dto.SignUpDTO;
import com.gbs.login.loginsignup.model.SignUp;
import com.gbs.login.loginsignup.repository.SignUpRepository;
import com.gbs.login.loginsignup.service.SignUpService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    SignUpRepository signUpRepository;

    @Autowired
    SignUpService signUpService;

    @GetMapping("")
    public ResponseEntity<List<SignUp>> getItems() {
        return ResponseEntity.ok().body(signUpService.findAll());
    }

    @PostMapping({ "/" , "" })
    public ResponseEntity<Map<Object , Object>> createItems(@RequestBody SignUp signUp) {
        Map<Object , Object> response = new HashMap<>();
        var it = signUpService.create(signUp);
        response.put("status" , HttpStatus.CREATED);
        response.put("signUp" , signUpService.save(signUp));
        response.put("location" , "/api/signUp/" + it.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    // TODO login cannot be from get method
    /**
     * 
     * Create a dto with username and password as the properties
     * Change the mapping to post
     * @param userName
     * @param password
     * @return
     */

    @GetMapping("/login")
    public HashMap<Object, Object> getUserByLogin(@RequestBody SignUpDTO signUpDTO) {
        var response = new HashMap<Object, Object>();

        ModelMapper modelMapper = new ModelMapper();
        SignUp signUp = modelMapper.map(signUpDTO, SignUp.class);

        
            if(signUp.getUserName() != null && signUp.getPassword() != null) {
                List<SignUp> listSignUps = new ArrayList<>();
                listSignUps = signUpService.getUserByLogin(signUp.getUserName(), signUp.getPassword());

                if(listSignUps.size() >= 1 && listSignUps != null) {
                    response.put("message", "user login successfully");
                }else {
                    response.put("message", "user login failed");
                }
            }            
       

     
        return response;
    }

    @GetMapping("/findByUserId/{id}")
    public ResponseEntity<Map<Object, Object>> findUser(@PathVariable Integer id) {
        Map<Object, Object> response = new HashMap<>();
        
        SignUp user = signUpService.findById(id).orElseThrow();
        response.put("status", HttpStatus.OK);
        response.put("user", user);
        
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    
    
}
