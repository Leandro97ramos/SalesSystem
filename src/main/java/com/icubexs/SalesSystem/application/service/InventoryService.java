package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.domain.model.Inventory;
import com.icubexs.SalesSystem.application.port.out.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Inventory assignStockToBin(Inventory inventory) {
        // TODO: Lógica Amazon Style
        // 1. Consultar dimensiones del Item asociado al Batch
        // 2. Validar contra la capacidad de configDetailId
        return inventoryRepository.save(inventory);
    }
}