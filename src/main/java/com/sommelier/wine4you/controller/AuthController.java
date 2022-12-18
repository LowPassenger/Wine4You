package com.sommelier.wine4you.controller;

import com.sommelier.wine4you.model.dto.UserLoginDto;
import com.sommelier.wine4you.model.dto.UserSignUpDto;
import com.sommelier.wine4you.repository.UserRepository;
import com.sommelier.wine4you.security.jwt.JwtAuthResponse;
import com.sommelier.wine4you.service.AuthenticationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(AuthenticationService authenticationService,
                          UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }

    @PostMapping("signin")
    public ResponseEntity<JwtAuthResponse> authentication(
            @Valid @RequestBody UserLoginDto loginDto) {
        String token = authenticationService.authentication(loginDto);
        return ResponseEntity.ok(new JwtAuthResponse(token));
    }

    @PostMapping("signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserSignUpDto signUpDto) {
        if (userRepository.existsByPhone(signUpDto.getPhone())) {
            return new ResponseEntity<>("Phone is ready taken!", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is ready taken!", HttpStatus.BAD_REQUEST);
        }

        authenticationService.registerUser(signUpDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
