package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.ConfiguracionTipoService;
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
    public ResponseEntity<ConfiguracionTipo> create(@RequestBody ConfiguracionTipo tipo) {
        return ResponseEntity.ok(service.create(tipo));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ConfiguracionTipo> getByCodigo(@PathVariable String codigo) {
        return service.findByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<ConfiguracionTipo>> getAllActive() {
        return ResponseEntity.ok(service.findAllActive());
    }
}