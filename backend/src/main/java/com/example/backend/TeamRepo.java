package com.example.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepo extends MongoRepository<TeamMate, String> {


}
