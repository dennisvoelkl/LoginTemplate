package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepo teamRepo;

    private final UserRepo userRepo;

    public List<TeamMate> findAll() {
        return teamRepo.findAll();
    }

    public void save(NewAppUser newAppUser) {
        String passwordBcrypt = SecurityConfig.passwordEncoder.encode(newAppUser.password());

        AppUser newUser = new AppUser(
                UUID.randomUUID()
                .toString(),
                newAppUser.username(),
                "Admin",
                passwordBcrypt
        );
        userRepo.save(newUser);
    }
}
