package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.port.in.OfferProductService;
import com.icubexs.SalesSystem.domain.model.OfferProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offer-products")
@RequiredArgsConstructor
public class OfferProductController {

    private final OfferProductService service;

    @PostMapping
    public ResponseEntity<OfferProduct> save(@RequestBody OfferProduct offerProduct) {
        return ResponseEntity.ok(service.save(offerProduct));
    }

    @GetMapping("/offer/{offerId}")
    public ResponseEntity<List<OfferProduct>> findByOffer(@PathVariable Long offerId) {
        return ResponseEntity.ok(service.findByOfferId(offerId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<OfferProduct>> findByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(service.findByProductId(productId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}