package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.InventoryTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InventoryTransferJpaRepository extends JpaRepository<InventoryTransferEntity, Long> {
    List<InventoryTransferEntity> findBySourceWarehouseId(Long sourceWarehouseId);
}