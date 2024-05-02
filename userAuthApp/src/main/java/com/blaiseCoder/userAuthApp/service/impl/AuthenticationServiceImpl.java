package com.blaiseCoder.userAuthApp.service.impl;

import com.blaiseCoder.userAuthApp.dto.SignUpRequest;
import com.blaiseCoder.userAuthApp.entities.User;
import com.blaiseCoder.userAuthApp.repositories.UserRepository;
import com.blaiseCoder.userAuthApp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl
//        implements AuthenticationService
{
    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;
//    @Override
//    public User signup(SignUpRequest signUpRequest) {
//
//
//    }
}
