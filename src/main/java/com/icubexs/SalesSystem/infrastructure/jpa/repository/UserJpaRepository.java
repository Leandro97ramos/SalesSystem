package com.icubexs.SalesSystem.infrastructure.jpa.repository;


import com.icubexs.SalesSystem.infrastructure.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);

    //existsByUsername
    boolean existsByUsername(String username);
}

