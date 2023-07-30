package com.awt.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.awt.entity.UserCredential;
import com.awt.repository.UserRepository;

@Component
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserCredential> credential = userRepository.findByName(username);
       return credential.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found with name: "+username));
       
    }
    
}
