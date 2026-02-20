package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Inventory;
import java.util.Optional;

public interface InventoryRepository {
    Inventory save(Inventory inventory);
    Optional<Inventory> findById(Long id);
}