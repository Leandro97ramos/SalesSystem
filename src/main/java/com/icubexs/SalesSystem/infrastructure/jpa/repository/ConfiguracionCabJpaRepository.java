package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionCabEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConfiguracionCabJpaRepository extends JpaRepository<ConfiguracionCabEntity, Long> {
    Optional<ConfiguracionCabEntity> findByCodigo(String codigo);
    List<ConfiguracionCabEntity> findByTipoId(Long tipoId);
}