package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.service.UserRoleService;
import com.icubexs.SalesSystem.domain.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-roles")
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService userRoleService;

    @PostMapping("/assign")
    public ResponseEntity<UserRole> assign(@RequestBody UserRole userRole) {
        return ResponseEntity.ok(userRoleService.assignRole(userRole));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserRole>> getRolesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userRoleService.getUserRoles(userId));
    }
}