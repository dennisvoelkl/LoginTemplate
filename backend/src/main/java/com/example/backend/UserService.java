package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public AppUser findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
