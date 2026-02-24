package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.ConfiguracionCabService;
import com.icubexs.SalesSystem.domain.model.ConfiguracionCab;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/configuracion-cabeceras")
@RequiredArgsConstructor
public class ConfiguracionCabController {

    private final ConfiguracionCabService service;

    @PostMapping
    public ResponseEntity<ConfiguracionCab> save(@RequestBody ConfiguracionCab cabecera) {
        return ResponseEntity.ok(service.save(cabecera));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ConfiguracionCab> getByCodigo(@PathVariable String codigo) {
        return service.findByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipoId}")
    public ResponseEntity<List<ConfiguracionCab>> getByTipo(@PathVariable Long tipoId) {
        return ResponseEntity.ok(service.findByTipo(tipoId));
    }
}