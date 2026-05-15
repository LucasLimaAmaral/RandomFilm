package com.pop.film.dto;

import com.pop.film.validation.annotations.PasswordMatches;
import com.pop.film.validation.annotations.ValidEmail;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@PasswordMatches
public record UserDTO(

    @NotNull
    @NotEmpty
    String name,

    @NotNull
    @NotEmpty
    String lastName,

    @NotNull
    @NotEmpty
    String password,

    @NotNull
    @NotEmpty
    String matchPassword,

    @NotNull
    @NotEmpty
    @ValidEmail
    String email

) {
} 
