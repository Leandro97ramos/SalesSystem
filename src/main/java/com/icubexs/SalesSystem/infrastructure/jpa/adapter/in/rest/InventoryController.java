package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.service.InventoryService;
import com.icubexs.SalesSystem.domain.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/assign")
    public ResponseEntity<Inventory> assignStock(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.assignStockToBin(inventory));
    }
}