package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.ConfiguracionDetService;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/configuracion-detalles")
@RequiredArgsConstructor
public class ConfiguracionDetController {

    private final ConfiguracionDetService service;

    @PostMapping
    public ResponseEntity<ConfiguracionDet> save(@RequestBody ConfiguracionDet detalle) {
        return ResponseEntity.ok(service.save(detalle));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ConfiguracionDet> getByCodigo(@PathVariable String codigo) {
        return service.findByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cabecera/{cabeceraCodigo}")
    public ResponseEntity<List<ConfiguracionDet>> getByCabecera(@PathVariable String cabeceraCodigo) {
        return ResponseEntity.ok(service.findByCabecera(cabeceraCodigo));
    }

    @GetMapping("/hijos/{padreId}")
    public ResponseEntity<List<ConfiguracionDet>> getChildren(@PathVariable Long padreId) {
        return ResponseEntity.ok(service.findChildren(padreId));
    }
}