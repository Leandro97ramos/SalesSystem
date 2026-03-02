package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;
import com.icubexs.SalesSystem.application.dto.req.UserRequestDTO;
import com.icubexs.SalesSystem.application.mapper.UserMapper;
import com.icubexs.SalesSystem.application.port.in.UserService;
import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.Person;
import com.icubexs.SalesSystem.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin

public class UserController {

    private final UserService service;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserRequestDTO request) {
        // 1. El mapper ahora sí se usa para convertir el DTO compuesto
        User userDomain = userMapper.toDomain(request);

        // 2. Llamamos al proceso de registro integral
        User savedUser = service.registerFullUser(userDomain, request.getRoles());

        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/check-email")
    public ResponseEntity<Map<String, Boolean>> checkEmail(@RequestParam String email) {
        boolean exists = service.existsByEmail(email);
        return ResponseEntity.ok(Map.of("exists", exists));
    }


}
