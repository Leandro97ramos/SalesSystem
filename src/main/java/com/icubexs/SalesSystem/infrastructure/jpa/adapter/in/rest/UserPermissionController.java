package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.UserPermissionService;
import com.icubexs.SalesSystem.domain.model.UserPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-permissions")
@RequiredArgsConstructor
public class UserPermissionController {

    private final UserPermissionService service;

    @PostMapping
    public ResponseEntity<UserPermission> save(@RequestBody UserPermission permission) {
        return ResponseEntity.ok(service.save(permission));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPermission>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.findByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}