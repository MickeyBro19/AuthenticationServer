package com.mickey.authenticationserver.dto;

public record RegisterRequest(
        String name,
        String email,
        String password
) {
}
