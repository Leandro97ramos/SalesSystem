package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.UserPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserPermissionJpaRepository extends JpaRepository<UserPermissionEntity, Long> {
    List<UserPermissionEntity> findByUserId(Long userId);
}