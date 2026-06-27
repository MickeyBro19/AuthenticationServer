package com.mickey.authenticationserver.controller;

import com.mickey.authenticationserver.config.AuthenticationService;
import com.mickey.authenticationserver.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        authenticationService.register(request);

        return ResponseEntity.ok("User Successfully Registered");

    }
}
