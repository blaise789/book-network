package com.blaiseCoder.userAuthApp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JWTService {
    String extractUsername(String token);
    String generateJwtToken(UserDetails userDetails);
}
