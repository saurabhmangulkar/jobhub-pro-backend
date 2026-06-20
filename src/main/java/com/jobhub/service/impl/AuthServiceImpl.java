package com.jobhub.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jobhub.dto.LoginRequest;
import com.jobhub.dto.LoginResponse;
import com.jobhub.dto.RegisterRequest;
import com.jobhub.entity.Role;
import com.jobhub.entity.User;
import com.jobhub.repository.RoleRepository;
import com.jobhub.repository.UserRepository;
import com.jobhub.security.JwtUtil;
import com.jobhub.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public AuthServiceImpl(
            UserRepository userRepository,
            RoleRepository roleRepository,
            BCryptPasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists";
        }

        Optional<Role> roleOptional =
                roleRepository.findByRoleName(request.getRoleName());

        if (roleOptional.isEmpty()) {
            return "Role not found";
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(
        	    passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setRole(roleOptional.get());

        userRepository.save(user);

        return "User registered successfully";
    }
    @Override
    public LoginResponse login(LoginRequest request) {

        Optional<User> userOptional =
                userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            return new LoginResponse("User not found");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

        	return new LoginResponse("Invalid password");
        }

        String token =
                jwtUtil.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}