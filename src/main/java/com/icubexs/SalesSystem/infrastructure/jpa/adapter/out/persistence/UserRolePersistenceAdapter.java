package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.domain.model.UserRole;
import com.icubexs.SalesSystem.application.port.out.UserRoleRepository;
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
    public UserRole save(UserRole userRole) {
        UserRoleEntity entity = new UserRoleEntity();
        entity.setUserId(userRole.getUserId());
        entity.setConfigDetailId(userRole.getConfigDetailId());
        entity.setStatus(userRole.getStatus());

        UserRoleEntity saved = jpaRepository.save(entity);
        return mapToDomain(saved);
    }

    @Override
    public Optional<UserRole> findById(Long id) {
        return jpaRepository.findById(id).map(this::mapToDomain);
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {
        return jpaRepository.findByUserId(userId).stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    private UserRole mapToDomain(UserRoleEntity entity) {
        return new UserRole(
                entity.getUserRoleId(), entity.getUserId(),
                entity.getConfigDetailId(), entity.getStatus()
        );
    }
}