package com.example.springgradle.security.authenticate;

import com.example.springgradle.security.JwtService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/authenticate")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

//    @PostMapping("/regenerate")
//    public ResponseEntity<AuthenticationResponse> regenerateToken(
//            @RequestBody AuthenticationService authenticationService
//    ) {
//        AuthenticationResponse response = authenticationService.regenerateToken(authenticationService.register(RegisterRequest.builder().build()).getToken());
//        return ResponseEntity.ok(response);
//    }
}
