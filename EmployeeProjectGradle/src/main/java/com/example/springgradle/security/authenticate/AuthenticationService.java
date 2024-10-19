package com.example.springgradle.security.authenticate;

import com.example.springgradle.EmployeeProjectGradleApplication;
import com.example.springgradle.model.User;
import com.example.springgradle.repository.UserRepository;
import com.example.springgradle.security.JwtService;
import com.example.springgradle.security.Role;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeProjectGradleApplication.class);

    public AuthenticationResponse registerUI(String username, String password) {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setPassword(password);

        logger.info("AuthenticationResponse :: " + username + " :: " + password);
        var user = User
                .builder()
                .email(username)
                .password(password)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.EMPLOYEE)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService
                .generateToken(user);

        logger.info("Token :: " + jwtToken);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User
                .builder()
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.EMPLOYEE)
                .build();
        userRepository.save(user);

        var jwtToken = jwtService
                .generateToken(user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );

        var jwtToken = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow();

        return AuthenticationResponse
                .builder()
                .token(String.valueOf(jwtToken))
                .build();
    }

//    public AuthenticationResponse regenerateToken(String oldToken) {
//        String userEmail = jwtService.extractUserName(oldToken);
//
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
//        if(!jwtService.isTokenValid(oldToken, userDetails)) {
//            throw new IllegalArgumentException("Invalid Token");
//        }
//
//        User user = userRepository.findByEmail(userEmail)
//                .orElseThrow(() -> new IllegalArgumentException("User not found")
//        );
//
//        String newToken = jwtService.generateToken(user);
//
//        return AuthenticationResponse
//                .builder()
//                .token(newToken)
//                .build();
//    }
}
