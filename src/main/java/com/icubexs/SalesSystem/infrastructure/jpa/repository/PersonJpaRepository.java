package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
    // Búsqueda por identificación (UNIQUE en el SQL)
    Optional<PersonEntity> findByIdentification(String identification);
}