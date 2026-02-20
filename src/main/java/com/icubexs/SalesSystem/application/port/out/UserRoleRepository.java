package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.UserRole;
import java.util.List;
import java.util.Optional;

public interface UserRoleRepository {
    UserRole save(UserRole userRole);
    Optional<UserRole> findById(Long id);
    List<UserRole> findByUserId(Long userId);
}