package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionTipoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface ConfiguracionTipoJpaRepository extends JpaRepository<ConfiguracionTipoEntity, Integer> {
    Optional<ConfiguracionTipoEntity> findByCodigo(String codigo);

    @Query("SELECT c FROM ConfiguracionTipoEntity c WHERE c.codigo LIKE :iniCodigo%")
    List<ConfiguracionTipoEntity> findByCodigoStartingWith(String iniCodigo);
}