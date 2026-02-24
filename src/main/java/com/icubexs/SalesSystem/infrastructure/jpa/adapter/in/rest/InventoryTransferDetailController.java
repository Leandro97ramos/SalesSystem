package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.InventoryTransferDetailService;
import com.icubexs.SalesSystem.domain.model.InventoryTransferDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory-transfer-details")
@RequiredArgsConstructor
public class InventoryTransferDetailController {

    private final InventoryTransferDetailService service;

    @PostMapping
    public ResponseEntity<InventoryTransferDetail> save(@RequestBody InventoryTransferDetail detail) {
        return ResponseEntity.ok(service.save(detail));
    }

    @GetMapping("/transfer/{transferId}")
    public ResponseEntity<List<InventoryTransferDetail>> findByTransfer(@PathVariable Long transferId) {
        return ResponseEntity.ok(service.findByTransferId(transferId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}