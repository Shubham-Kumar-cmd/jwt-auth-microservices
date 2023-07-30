package com.awt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.awt.entity.UserCredential;
import com.awt.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public UserCredential saveUser(UserCredential credential){
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        UserCredential user = userRepository.save(credential);
        return user;
    }

    public String generateToken(String userName){
        return jwtUtil.generateToken(userName);
    }

    public Jws<Claims> validateToken(String token){
        return jwtUtil.validateToken(token);
    }
}
