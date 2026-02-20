package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.domain.model.UserPermission;
import com.icubexs.SalesSystem.application.port.out.UserPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPermissionService {
    private final UserPermissionRepository userPermissionRepository;

    public UserPermission grantPermission(UserPermission permission) {
        // Aquí podrías validar que el userId y configTypeId existan antes de guardar
        return userPermissionRepository.save(permission);
    }

    public List<UserPermission> getUserPermissions(Long userId) {
        return userPermissionRepository.findByUserId(userId);
    }
}