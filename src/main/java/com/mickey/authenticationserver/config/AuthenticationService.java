package com.mickey.authenticationserver.config;

import com.mickey.authenticationserver.dto.RegisterRequest;

public interface AuthenticationService {
    void register(RegisterRequest request);
}
