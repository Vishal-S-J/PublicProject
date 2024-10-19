package com.example.springgradle.security.authenticate;

import com.example.springgradle.web.View;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/registerUI")
    public String registerFromUI(
            @RequestParam String username,
            @RequestParam String password
    ) {
        System.out.println("registerFromUI :: " + ResponseEntity.ok(authenticationService.registerUI(username, password)));
        ResponseEntity<AuthenticationResponse> response = ResponseEntity.ok(authenticationService.registerUI(username, password));

        if(response.getStatusCode().is2xxSuccessful()) {
            return View.INDEX;
//            return "redirect:/index";
        }
        return "Wrong page";
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
