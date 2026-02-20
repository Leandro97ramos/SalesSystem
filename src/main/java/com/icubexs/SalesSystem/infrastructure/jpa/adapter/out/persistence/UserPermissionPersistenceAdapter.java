package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.domain.model.UserPermission;
import com.icubexs.SalesSystem.application.port.out.UserPermissionRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.UserPermissionEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.UserPermissionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserPermissionPersistenceAdapter implements UserPermissionRepository {
    private final UserPermissionJpaRepository jpaRepository;

    @Override
    public UserPermission save(UserPermission permission) {
        UserPermissionEntity entity = new UserPermissionEntity();
        entity.setUserId(permission.getUserId());
        entity.setConfigTypeId(permission.getConfigTypeId());
        entity.setPermissionLevel(permission.getPermissionLevel());

        UserPermissionEntity saved = jpaRepository.save(entity);
        return mapToDomain(saved);
    }

    @Override
    public Optional<UserPermission> findById(Long id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public List<UserPermission> findByUserId(Long userId) {
        return jpaRepository.findByUserId(userId).stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    private UserPermission mapToDomain(UserPermissionEntity entity) {
        return new UserPermission(
                entity.getUserPermissionId(), entity.getUserId(),
                entity.getConfigTypeId(), entity.getPermissionLevel()
        );
    }
}