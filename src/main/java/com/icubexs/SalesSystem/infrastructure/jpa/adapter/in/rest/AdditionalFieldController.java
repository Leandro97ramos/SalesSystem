package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.AdditionalFieldService;
import com.icubexs.SalesSystem.domain.model.AdditionalField;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/additional-fields")
@RequiredArgsConstructor
public class AdditionalFieldController {

    private final AdditionalFieldService service;

    @PostMapping
    public ResponseEntity<AdditionalField> save(@RequestBody AdditionalField additionalField) {
        return ResponseEntity.ok(service.save(additionalField));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdditionalField> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AdditionalField>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}