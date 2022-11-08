package com.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
