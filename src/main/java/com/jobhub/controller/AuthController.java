package com.jobhub.controller;

import org.springframework.web.bind.annotation.*;

import com.jobhub.dto.LoginRequest;
import com.jobhub.dto.RegisterRequest;
import com.jobhub.security.JwtUtil;
import com.jobhub.service.AuthService;
import com.jobhub.dto.LoginResponse;
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService,
                          JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }
    @GetMapping("/token")
    public String token() {
        return jwtUtil.generateToken("saurabh@test.com");
    }
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        return authService.register(request);
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        return authService.login(request);
    }
}