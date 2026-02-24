package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;



import com.icubexs.SalesSystem.application.port.in.UserRoleService;
import com.icubexs.SalesSystem.domain.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService service;

    @PostMapping
    public ResponseEntity<UserRole> save(@RequestBody UserRole userRole) {
        return ResponseEntity.ok(service.save(userRole));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserRole>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.findByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}