package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.TaxRuleService;
import com.icubexs.SalesSystem.domain.model.TaxRule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tax-rules")
@RequiredArgsConstructor
public class TaxRuleController {

    private final TaxRuleService service;

    @PostMapping
    public ResponseEntity<TaxRule> save(@RequestBody TaxRule taxRule) {
        return ResponseEntity.ok(service.save(taxRule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaxRule> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/geo-location/{geoLocationId}")
    public ResponseEntity<List<TaxRule>> findByGeoLocation(@PathVariable Long geoLocationId) {
        return ResponseEntity.ok(service.findByGeoLocationId(geoLocationId));
    }

    @GetMapping
    public ResponseEntity<List<TaxRule>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
