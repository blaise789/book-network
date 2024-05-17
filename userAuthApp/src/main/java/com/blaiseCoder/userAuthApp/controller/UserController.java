package com.blaiseCoder.userAuthApp.controller;

import com.blaiseCoder.userAuthApp.dto.SignUpRequest;
import com.blaiseCoder.userAuthApp.entities.User;
import com.blaiseCoder.userAuthApp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService ahuthenticationService;
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody() SignUpRequest signupRequest){
        return ResponseEntity.ok(authenticationService.signup(signupRequest));
    }


}
