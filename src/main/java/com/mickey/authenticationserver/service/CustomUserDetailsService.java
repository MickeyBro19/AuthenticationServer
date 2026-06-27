package com.mickey.authenticationserver.service;

import com.mickey.authenticationserver.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException{
        return repo.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User not Found"));
    }
}
