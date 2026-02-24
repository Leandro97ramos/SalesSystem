package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.InventoryTransfer;
import java.util.List;
import java.util.Optional;

public interface InventoryTransferService {
    InventoryTransfer createTransfer(InventoryTransfer transfer);
    Optional<InventoryTransfer> findById(Long id);
    List<InventoryTransfer> findAll();
    List<InventoryTransfer> findBySourceWarehouse(Long warehouseId);
}