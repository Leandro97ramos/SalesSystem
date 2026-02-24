package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.OfferProductRepository;
import com.icubexs.SalesSystem.domain.model.Offer;
import com.icubexs.SalesSystem.domain.model.OfferProduct;
import com.icubexs.SalesSystem.domain.model.Product;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.OfferEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.OfferProductEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ProductEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.OfferProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OfferProductPersistenceAdapter implements OfferProductRepository {

    private final OfferProductJpaRepository jpaRepository;

    @Override
    public OfferProduct save(OfferProduct domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public List<OfferProduct> findByOfferId(Long offerId) {
        return jpaRepository.findByOfferId(offerId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<OfferProduct> findByProductId(Long productId) {
        return jpaRepository.findByProductId(productId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<OfferProduct> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private OfferProduct toDomain(OfferProductEntity entity) {
        if (entity == null) return null;
        return OfferProduct.builder()
                .id(entity.getId())
                .offer(entity.getOffer() != null ?
                        Offer.builder().id(entity.getOffer().getId()).name(entity.getOffer().getName()).build() : null)
                .product(entity.getProduct() != null ?
                        Product.builder().id(entity.getProduct().getId()).name(entity.getProduct().getName()).sku(entity.getProduct().getSku()).build() : null)
                .build();
    }

    private OfferProductEntity toEntity(OfferProduct domain) {
        if (domain == null) return null;
        return OfferProductEntity.builder()
                .id(domain.getId())
                .offer(domain.getOffer() != null ? OfferEntity.builder().id(domain.getOffer().getId()).build() : null)
                .product(domain.getProduct() != null ? ProductEntity.builder().id(domain.getProduct().getId()).build() : null)
                .build();
    }
}