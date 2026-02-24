package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConfiguracionDetJpaRepository extends JpaRepository<ConfiguracionDetEntity, Long> {
    Optional<ConfiguracionDetEntity> findByCodigo(String codigo);
    List<ConfiguracionDetEntity> findByCabeceraCodigo(String cabeceraCodigo);
    List<ConfiguracionDetEntity> findByPadreId(Long padreId);
}