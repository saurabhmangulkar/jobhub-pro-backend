package com.jobhub.service;

import com.jobhub.dto.LoginRequest;
import com.jobhub.dto.LoginResponse;
import com.jobhub.dto.RegisterRequest;

public interface AuthService {

	
    String register(RegisterRequest request);
    
    LoginResponse login(LoginRequest request); 
}