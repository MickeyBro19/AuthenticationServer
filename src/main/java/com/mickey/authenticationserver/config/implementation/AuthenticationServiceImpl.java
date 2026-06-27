package com.mickey.authenticationserver.config.implementation;

import com.mickey.authenticationserver.config.AuthenticationService;
import com.mickey.authenticationserver.dto.RegisterRequest;
import com.mickey.authenticationserver.entity.Role;
import com.mickey.authenticationserver.entity.User;
import com.mickey.authenticationserver.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    public AuthenticationServiceImpl(UserRepository userRepo,PasswordEncoder encoder){
        this.userRepo=userRepo;
        this.encoder=encoder;
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
}
