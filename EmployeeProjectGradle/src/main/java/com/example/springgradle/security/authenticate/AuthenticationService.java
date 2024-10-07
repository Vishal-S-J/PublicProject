package com.example.springgradle.security.authenticate;

import com.example.springgradle.model.User;
import com.example.springgradle.repository.UserRepository;
import com.example.springgradle.security.JwtService;
import com.example.springgradle.security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

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
}
