package com.blaiseCoder.userAuthApp.service.impl;

import com.blaiseCoder.userAuthApp.dto.SignUpRequest;
import com.blaiseCoder.userAuthApp.entities.Role;
import com.blaiseCoder.userAuthApp.entities.User;
import com.blaiseCoder.userAuthApp.repositories.UserRepository;
import com.blaiseCoder.userAuthApp.service.AuthenticationService;
import com.blaiseCoder.userAuthApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl  implements AuthenticationService
//        implements AuthenticationService
{
    private final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;
//    @Override
    public User signup(SignUpRequest signUpRequest) {

  User user=new User();
  user.setFirstName(signUpRequest.getFirstName());
  user.setLastName(signUpRequest.getLastName());
  user.setEmail(signUpRequest.getEmail());
  user.setRole(Role.USER);
  user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));


  return userRepository.save(user);
    }
}
