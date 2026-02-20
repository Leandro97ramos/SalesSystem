package com.icubexs.SalesSystem.infraestructure.jpa.repository;

import com.icubexs.SalesSystem.infraestructure.jpa.entity.ItemEntity;

import java.util.Optional;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {
    // Spring implementará esto automáticamente
    Optional<ItemEntity> findByCodigoSku(String codigoSku);
}