package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.GeoLocationService;
import com.icubexs.SalesSystem.domain.model.GeoLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/geo-locations")
@RequiredArgsConstructor
public class GeoLocationController {

    private final GeoLocationService service;

    @PostMapping
    public ResponseEntity<GeoLocation> save(@RequestBody GeoLocation geoLocation) {
        return ResponseEntity.ok(service.save(geoLocation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeoLocation> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GeoLocation>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}