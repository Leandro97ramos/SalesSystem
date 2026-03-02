package com.icubexs.SalesSystem.infrastructure.jpa.repository;


import com.icubexs.SalesSystem.infrastructure.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);

    // Spring Boot crea la consulta: SELECT COUNT(*) > 0 FROM app_user WHERE email = ?
    boolean existsByEmail(String email);

    @Modifying // Indica que es una operación de escritura
    @Query(value = "INSERT INTO user_role (user_id, configuracion_det_id) VALUES (:userId, :roleId)", nativeQuery = true)
    void assignRole(@Param("userId") Long userId, @Param("roleId") Long roleId);
}

