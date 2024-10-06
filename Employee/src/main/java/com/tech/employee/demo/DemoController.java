package com.tech.employee.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simp")
public class DemoController {

    @GetMapping("/demo-controller")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured line");
    }
}
