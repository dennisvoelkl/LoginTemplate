package com.example.backend;

import javax.validation.constraints.Min;

public record NewAppUser (

        @Min(message = "username too short", value = 6)
        String username,
        @Min(message = "password too short", value = 6)
        String password)
{
}
