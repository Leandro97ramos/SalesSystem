package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.ProductInfoService;
import com.icubexs.SalesSystem.domain.model.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-infos")
@RequiredArgsConstructor
public class ProductInfoController {

    private final ProductInfoService service;

    @PostMapping
    public ResponseEntity<ProductInfo> save(@RequestBody ProductInfo productInfo) {
        return ResponseEntity.ok(service.save(productInfo));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductInfo>> findByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(service.findByProductId(productId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}