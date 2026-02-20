package com.icubexs.SalesSystem.infraestructure.jpa.repository;


import com.icubexs.SalesSystem.infraestructure.jpa.entity.LoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LoteJpaRepository extends LoteJpaRepository<LoteEntity, Long> {
    // Para buscar un lote específico por su código de trazabilidad
    Optional<LoteEntity> findByCodigoLote(String codigoLote);
}