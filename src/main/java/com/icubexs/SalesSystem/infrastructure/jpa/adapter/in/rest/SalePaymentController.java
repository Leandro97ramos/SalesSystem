package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.SalePaymentService;
import com.icubexs.SalesSystem.domain.model.SalePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sale-payments")
@RequiredArgsConstructor
public class SalePaymentController {

    private final SalePaymentService service;

    @PostMapping
    public ResponseEntity<SalePayment> register(@RequestBody SalePayment payment) {
        return ResponseEntity.ok(service.registerPayment(payment));
    }

    @GetMapping("/sale/{saleId}")
    public ResponseEntity<List<SalePayment>> getBySale(@PathVariable Long saleId) {
        return ResponseEntity.ok(service.findBySaleId(saleId));
    }
}