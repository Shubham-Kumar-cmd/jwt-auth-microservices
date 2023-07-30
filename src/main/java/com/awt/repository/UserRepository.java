package com.awt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.awt.entity.UserCredential;

public interface UserRepository extends JpaRepository<UserCredential,Integer>{
    Optional<UserCredential> findByName(String username);    
}
