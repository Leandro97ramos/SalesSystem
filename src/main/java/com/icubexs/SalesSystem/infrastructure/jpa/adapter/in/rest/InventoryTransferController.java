package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.InventoryTransferService;
import com.icubexs.SalesSystem.domain.model.InventoryTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory-transfers")
@RequiredArgsConstructor
public class InventoryTransferController {

    private final InventoryTransferService service;

    @PostMapping
    public ResponseEntity<InventoryTransfer> create(@RequestBody InventoryTransfer transfer) {
        return ResponseEntity.ok(service.createTransfer(transfer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryTransfer> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<InventoryTransfer>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/source-warehouse/{warehouseId}")
    public ResponseEntity<List<InventoryTransfer>> findBySourceWarehouse(@PathVariable Long warehouseId) {
        return ResponseEntity.ok(service.findBySourceWarehouse(warehouseId));
    }
}