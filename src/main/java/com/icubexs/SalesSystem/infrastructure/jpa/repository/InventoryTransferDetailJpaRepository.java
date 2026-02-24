package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.InventoryTransferDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InventoryTransferDetailJpaRepository extends JpaRepository<InventoryTransferDetailEntity, Long> {
    List<InventoryTransferDetailEntity> findByInventoryTransferId(Long inventoryTransferId);
}