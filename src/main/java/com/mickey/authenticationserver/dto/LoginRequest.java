package com.mickey.authenticationserver.dto;

public record LoginRequest(
        String email,
        String password
) {
}
