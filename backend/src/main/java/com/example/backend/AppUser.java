package com.example.backend;

public record AppUser (
        String id,
        String username,
        String roles,
        String passwordBcrypt)
{
}
