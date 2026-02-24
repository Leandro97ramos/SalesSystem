package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.SaleDetailRepository;
import com.icubexs.SalesSystem.domain.model.*;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.*;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.SaleDetailJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SaleDetailPersistenceAdapter implements SaleDetailRepository {

    private final SaleDetailJpaRepository jpaRepository;

    @Override
    public SaleDetail save(SaleDetail domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<SaleDetail> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<SaleDetail> findBySaleId(Long saleId) {
        return jpaRepository.findBySaleId(saleId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private SaleDetail toDomain(SaleDetailEntity entity) {
        if (entity == null) return null;
        return SaleDetail.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .unitPrice(entity.getUnitPrice())
                .appliedTaxRate(entity.getAppliedTaxRate())
                .taxAmount(entity.getTaxAmount())
                .discountAmount(entity.getDiscountAmount())
                .total(entity.getTotal())
                .sale(entity.getSale() != null ? SaleHeader.builder().id(entity.getSale().getId()).build() : null)
                .product(entity.getProduct() != null ? Product.builder().id(entity.getProduct().getId()).name(entity.getProduct().getName()).build() : null)
                .offer(entity.getOffer() != null ? Offer.builder().id(entity.getOffer().getId()).build() : null)
                .taxRate(entity.getTaxRate() != null ? ConfiguracionDet.builder().id(entity.getTaxRate().getId()).build() : null)
                .build();
    }

    private SaleDetailEntity toEntity(SaleDetail domain) {
        if (domain == null) return null;
        return SaleDetailEntity.builder()
                .id(domain.getId())
                .quantity(domain.getQuantity())
                .unitPrice(domain.getUnitPrice())
                .appliedTaxRate(domain.getAppliedTaxRate())
                .taxAmount(domain.getTaxAmount())
                .discountAmount(domain.getDiscountAmount())
                .total(domain.getTotal())
                .sale(domain.getSale() != null ? SaleHeaderEntity.builder().id(domain.getSale().getId()).build() : null)
                .product(domain.getProduct() != null ? ProductEntity.builder().id(domain.getProduct().getId()).build() : null)
                .offer(domain.getOffer() != null ? OfferEntity.builder().id(domain.getOffer().getId()).build() : null)
                .taxRate(domain.getTaxRate() != null ? ConfiguracionDetEntity.builder().id(domain.getTaxRate().getId()).build() : null)
                .build();
    }
}