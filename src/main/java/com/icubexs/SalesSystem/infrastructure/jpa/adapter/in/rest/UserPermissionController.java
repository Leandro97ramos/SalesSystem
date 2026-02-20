package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.service.UserPermissionService;
import com.icubexs.SalesSystem.domain.model.UserPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-permissions")
@RequiredArgsConstructor
public class UserPermissionController {
    private final UserPermissionService userPermissionService;

    @PostMapping
    public ResponseEntity<UserPermission> grant(@RequestBody UserPermission permission) {
        return ResponseEntity.ok(userPermissionService.grantPermission(permission));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserPermission>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userPermissionService.getUserPermissions(userId));
    }
}