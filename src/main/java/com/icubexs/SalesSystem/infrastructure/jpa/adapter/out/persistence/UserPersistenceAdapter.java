package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;
import com.icubexs.SalesSystem.application.port.out.UserRepository;
import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.Person;
import com.icubexs.SalesSystem.domain.model.User;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.CompanyEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.PersonEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.UserEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserRepository {

    private final UserJpaRepository jpaRepository;

    @Override
    public User save(User domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpaRepository.findByUsername(username).map(this::toDomain);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // --- Mapeo Manual ---
    private User toDomain(UserEntity entity) {
        if (entity == null) return null;
        return User.builder()
                .id(entity.getId()) // o getUserId() si lo renombraste
                .username(entity.getUsername())
                .passwordHash(entity.getPasswordHash()) // o getPassword() si lo renombraste
                .email(entity.getEmail())
                // Aquí ya no debería dar error si el campo existe en la entidad
                .person(entity.getPerson() != null ?
                        Person.builder().id(entity.getPerson().getId()).build() : null)
                .company(entity.getCompany() != null ?
                        Company.builder().id(entity.getCompany().getId()).build() : null)
                .build();
    }

    private UserEntity toEntity(User domain) {
        if (domain == null) return null;
        return UserEntity.builder()
                .id(domain.getId())
                .username(domain.getUsername())
                .passwordHash(domain.getPasswordHash())
                .email(domain.getEmail())
                .person(domain.getPerson() != null ? PersonEntity.builder().id(domain.getPerson().getId()).build() : null)
                .company(domain.getCompany() != null ? CompanyEntity.builder().id(domain.getCompany().getId()).build() : null)
                .build();
    }
}