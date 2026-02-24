package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.InventoryTransferDetail;
import java.util.List;
import java.util.Optional;

public interface InventoryTransferDetailService {
    InventoryTransferDetail save(InventoryTransferDetail detail);
    List<InventoryTransferDetail> findByTransferId(Long transferId);
    void deleteById(Long id);
}