package com.gbs.login.loginsignup.repository;

import java.util.List;
import java.util.Optional;
import com.gbs.login.loginsignup.model.SignUp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SignUpRepository extends JpaRepository <SignUp,Integer> {

    

    @Query("FROM SignUp p WHERE p.userName = ?1 and p.password = ?2")
    List<SignUp> getUserByLogin(String userName, String password);

    Optional<SignUp> findByUserNameAndPassword(String userName, String password);
    
}
