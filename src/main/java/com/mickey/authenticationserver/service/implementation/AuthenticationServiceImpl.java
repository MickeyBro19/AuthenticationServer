package com.mickey.authenticationserver.service.implementation;

import com.mickey.authenticationserver.dto.AuthResponse;
import com.mickey.authenticationserver.service.AuthenticationService;
import com.mickey.authenticationserver.dto.LoginRequest;
import com.mickey.authenticationserver.dto.RegisterRequest;
import com.mickey.authenticationserver.entity.Role;
import com.mickey.authenticationserver.entity.User;
import com.mickey.authenticationserver.repo.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private  final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserRepository userRepo,PasswordEncoder encoder,AuthenticationManager authenticationManager){
        this.userRepo=userRepo;
        this.encoder=encoder;
        this.authenticationManager=authenticationManager;
    }

    @Override
    public void register(RegisterRequest request) {

        if(userRepo.findByEmail(request.email()).isPresent()){
            throw new RuntimeException("User already exists");
        }
        User user= User.builder()
                .name(request.name())
                .email(request.email())
                .password(encoder.encode(request.password()))
                .role(Role.USER)
                .build();

        userRepo.save(user);

    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        return new AuthResponse("Login Successful");
    }
}
