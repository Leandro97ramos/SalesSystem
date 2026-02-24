package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.OfferService;
import com.icubexs.SalesSystem.domain.model.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService service;

    @PostMapping
    public ResponseEntity<Offer> save(@RequestBody Offer offer) {
        return ResponseEntity.ok(service.save(offer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Offer>> findAllActive() {
        return ResponseEntity.ok(service.findAllActive());
    }
}