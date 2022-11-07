package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepo teamRepo;

    public List<TeamMate> findAll() {
        return teamRepo.findAll();
    }
}
