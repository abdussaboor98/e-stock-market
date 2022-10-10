package com.estockmarket.authservice.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.estockmarket.authservice.entity.User;

public interface UserRepo extends MongoRepository<User, String> {
    
    Optional<User> findByEmail(String email);
    
    Optional<User> findByUsername(String username);
}
