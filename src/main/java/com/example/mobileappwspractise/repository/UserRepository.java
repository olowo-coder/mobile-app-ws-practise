package com.example.mobileappwspractise.repository;

import com.example.mobileappwspractise.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDetails, String> {
    Optional<UserDetails> findByEmail(String email);
}
