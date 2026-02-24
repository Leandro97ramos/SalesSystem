package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.InventoryTransfer;
import java.util.List;
import java.util.Optional;

public interface InventoryTransferRepository {
    InventoryTransfer save(InventoryTransfer transfer);
    Optional<InventoryTransfer> findById(Long id);
    List<InventoryTransfer> findAll();
    List<InventoryTransfer> findBySourceWarehouseId(Long warehouseId);
}