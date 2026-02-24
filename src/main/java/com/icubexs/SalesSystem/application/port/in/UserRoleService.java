package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.UserRole;
import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    UserRole save(UserRole userRole);
    Optional<UserRole> findById(Long id);
    List<UserRole> findByUserId(Long userId);
    void deleteById(Long id);
}