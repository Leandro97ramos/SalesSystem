package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.SaleDetailService;
import com.icubexs.SalesSystem.domain.model.SaleDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale-details")
@RequiredArgsConstructor
public class SaleDetailController {

    private final SaleDetailService service;

    @PostMapping
    public ResponseEntity<SaleDetail> add(@RequestBody SaleDetail detail) {
        return ResponseEntity.ok(service.addDetail(detail));
    }

    @GetMapping("/sale/{saleId}")
    public ResponseEntity<List<SaleDetail>> getBySale(@PathVariable Long saleId) {
        return ResponseEntity.ok(service.findBySaleId(saleId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.removeDetail(id);
        return ResponseEntity.noContent().build();
    }
}