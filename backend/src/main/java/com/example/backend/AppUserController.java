package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/app-users")
@RequiredArgsConstructor
public class AppUserController {

    private final TeamService teamService;

    @GetMapping("/login")
    public String login(){
        return "ok";
    }

    @GetMapping("/logout")
    public void logout(HttpSession httpSession){
        httpSession.invalidate();
    }

    @GetMapping("/me")
    public String me(){
        User loggedInUser=(User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

                return loggedInUser.toString();
    }

    @PostMapping()
    public ResponseEntity<Void> registration(@RequestBody @Valid NewAppUser newAppUser){
        teamService.save(newAppUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
