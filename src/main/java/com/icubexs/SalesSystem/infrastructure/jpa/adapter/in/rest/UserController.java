package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.service.UserService;
import com.icubexs.SalesSystem.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }
}
