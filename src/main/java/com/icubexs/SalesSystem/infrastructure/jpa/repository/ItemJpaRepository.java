package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.ItemEntity;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {
    // Spring implementará esto automáticamente
    Optional<ItemEntity> findBySkuCode(String skuCode);


}