package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;


import com.icubexs.SalesSystem.application.port.out.UserRoleRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.User;
import com.icubexs.SalesSystem.domain.model.UserRole;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.UserEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.UserRoleEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.UserRoleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserRolePersistenceAdapter implements UserRoleRepository {

    private final UserRoleJpaRepository jpaRepository;

    @Override
    public UserRole save(UserRole domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<UserRole> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        return jpaRepository.findByUserId(userId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // --- MAPEO MANUAL ---
    private UserRole toDomain(UserRoleEntity entity) {
        if (entity == null) return null;
        return UserRole.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .user(User.builder().id(entity.getUser().getId()).build())
                .roleConfig(ConfiguracionDet.builder()
                        .id(entity.getRoleConfig().getId())
                        .nombre(entity.getRoleConfig().getNombre())
                        .build())
                .build();
    }

    private UserRoleEntity toEntity(UserRole domain) {
        if (domain == null) return null;
        return UserRoleEntity.builder()
                .id(domain.getId())
                .status(domain.getStatus())
                .user(UserEntity.builder().id(domain.getUser().getId()).build())
                .roleConfig(ConfiguracionDetEntity.builder().id(domain.getRoleConfig().getId()).build())
                .build();
    }
}