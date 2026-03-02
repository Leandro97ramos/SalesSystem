package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return userService.findByEmail(request.getEmail())
                .filter(user -> user.getPasswordHash().equals(request.getPassword()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }

    // Clase DTO simple para recibir los datos
    @Data
    public static class LoginRequest {
        private String email;
        private String password;
    }
}