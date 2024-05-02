package com.blaiseCoder.userAuthApp.service;

import com.blaiseCoder.userAuthApp.dto.SignUpRequest;
import com.blaiseCoder.userAuthApp.entities.User;

public interface AuthenticationService {
    public User signup(SignUpRequest signUpRequest);


}
