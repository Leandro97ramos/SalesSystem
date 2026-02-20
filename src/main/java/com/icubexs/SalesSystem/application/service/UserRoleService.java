package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.domain.model.UserRole;
import com.icubexs.SalesSystem.application.port.out.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRole assignRole(UserRole userRole) {
        // En el futuro: Validar que el configDetailId corresponda a un Rol válido
        return userRoleRepository.save(userRole);
    }

    public List<UserRole> getUserRoles(Long userId) {
        return userRoleRepository.findByUserId(userId);
    }
}