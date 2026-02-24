package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.UserPermission;
import java.util.List;
import java.util.Optional;

public interface UserPermissionRepository {
    UserPermission save(UserPermission permission);
    Optional<UserPermission> findById(Long id);
    List<UserPermission> findByUserId(Long userId);
    void deleteById(Long id);
}