package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;


import com.icubexs.SalesSystem.application.port.out.UserPermissionRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.User;
import com.icubexs.SalesSystem.domain.model.UserPermission;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.UserEntity;
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
    public UserPermission save(UserPermission domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<UserPermission> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<UserPermission> findByUserId(Long userId) {
        return jpaRepository.findByUserId(userId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // --- MAPEO MANUAL ---
    private UserPermission toDomain(UserPermissionEntity entity) {
        if (entity == null) return null;
        return UserPermission.builder()
                .id(entity.getId())
                .permissionLevel(entity.getPermissionLevel())
                .user(User.builder().id(entity.getUser().getId()).build())
                .permissionConfig(ConfiguracionDet.builder()
                        .id(entity.getPermissionConfig().getId())
                        .nombre(entity.getPermissionConfig().getNombre())
                        .build())
                .build();
    }

    private UserPermissionEntity toEntity(UserPermission domain) {
        if (domain == null) return null;
        return UserPermissionEntity.builder()
                .id(domain.getId())
                .permissionLevel(domain.getPermissionLevel())
                .user(UserEntity.builder().id(domain.getUser().getId()).build())
                .permissionConfig(ConfiguracionDetEntity.builder()
                        .id(domain.getPermissionConfig().getId())
                        .build())
                .build();
    }
}