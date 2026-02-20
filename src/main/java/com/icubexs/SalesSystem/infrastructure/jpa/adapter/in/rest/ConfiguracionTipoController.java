package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.service.ConfiguracionTipoService;
import com.icubexs.SalesSystem.domain.model.ConfiguracionTipo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/configuracion-tipos")
@RequiredArgsConstructor
public class ConfiguracionTipoController {
    private final ConfiguracionTipoService service;

    @PostMapping
    public ResponseEntity<ConfiguracionTipo> create(@RequestBody ConfiguracionTipo request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ConfiguracionTipo>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/nuevo-codigo/{inicial}")
    public ResponseEntity<String> getNextCode(@PathVariable String inicial) {
        return ResponseEntity.ok(service.getNuevoCodigo(inicial));
    }
}