package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {
    Optional<ItemEntity> findBySerialNumber(String serialNumber);
    List<ItemEntity> findByProductId(Long productId);
    List<ItemEntity> findByBatchId(Long batchId);
}