package com.mickey.authenticationserver.service;

import com.mickey.authenticationserver.dto.AuthResponse;
import com.mickey.authenticationserver.dto.LoginRequest;
import com.mickey.authenticationserver.dto.RegisterRequest;
import org.springframework.security.authentication.AuthenticationManager;

public interface AuthenticationService {

    void register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
