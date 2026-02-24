package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.SaleDetailStockService;
import com.icubexs.SalesSystem.domain.model.SaleDetailStock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale-detail-stocks")
@RequiredArgsConstructor
public class SaleDetailStockController {

    private final SaleDetailStockService service;

    @PostMapping
    public ResponseEntity<SaleDetailStock> save(@RequestBody SaleDetailStock detailStock) {
        return ResponseEntity.ok(service.save(detailStock));
    }

    @GetMapping("/detail/{saleDetailId}")
    public ResponseEntity<List<SaleDetailStock>> getByDetail(@PathVariable Long saleDetailId) {
        return ResponseEntity.ok(service.findBySaleDetailId(saleDetailId));
    }
}