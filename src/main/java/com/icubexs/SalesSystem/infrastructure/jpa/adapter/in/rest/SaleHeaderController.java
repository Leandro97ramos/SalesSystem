package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.SaleHeaderService;
import com.icubexs.SalesSystem.domain.model.SaleHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleHeaderController {

    private final SaleHeaderService service;

    @PostMapping
    public ResponseEntity<SaleHeader> create(@RequestBody SaleHeader saleHeader) {
        return ResponseEntity.ok(service.createSale(saleHeader));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleHeader> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<SaleHeader>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}