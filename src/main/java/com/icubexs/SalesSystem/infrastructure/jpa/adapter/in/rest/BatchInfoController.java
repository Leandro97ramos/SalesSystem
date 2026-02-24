package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.BatchInfoService;
import com.icubexs.SalesSystem.domain.model.BatchInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/batch-infos")
@RequiredArgsConstructor
public class BatchInfoController {

    private final BatchInfoService service;

    @PostMapping
    public ResponseEntity<BatchInfo> save(@RequestBody BatchInfo batchInfo) {
        return ResponseEntity.ok(service.save(batchInfo));
    }

    @GetMapping("/batch/{batchId}")
    public ResponseEntity<List<BatchInfo>> findByBatch(@PathVariable Long batchId) {
        return ResponseEntity.ok(service.findByBatchId(batchId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}