package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.BatchEntity;
import java.util.Optional;

public interface BatchJpaRepository extends JpaRepository<BatchEntity, Long> {
    // Para buscar un lote específico por su código de trazabilidad
    Optional<BatchEntity> findByCodigoBatch(String codigoBatch);
}