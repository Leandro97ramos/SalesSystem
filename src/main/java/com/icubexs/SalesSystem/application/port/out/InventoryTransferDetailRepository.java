package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.InventoryTransferDetail;
import java.util.List;
import java.util.Optional;

public interface InventoryTransferDetailRepository {
    InventoryTransferDetail save(InventoryTransferDetail detail);
    List<InventoryTransferDetail> findByTransferId(Long transferId);
    Optional<InventoryTransferDetail> findById(Long id);
    void deleteById(Long id);
}