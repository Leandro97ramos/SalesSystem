package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.SaleHeaderRepository;
import com.icubexs.SalesSystem.domain.model.*;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.*;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.SaleHeaderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SaleHeaderPersistenceAdapter implements SaleHeaderRepository {

    private final SaleHeaderJpaRepository jpaRepository;

    @Override
    public SaleHeader save(SaleHeader domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<SaleHeader> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<SaleHeader> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<SaleHeader> findBySellerId(Long sellerId) {
        return jpaRepository.findBySellerId(sellerId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    private SaleHeader toDomain(SaleHeaderEntity entity) {
        if (entity == null) return null;
        return SaleHeader.builder()
                .id(entity.getId())
                .saleDate(entity.getSaleDate())
                .subtotal(entity.getSubtotal())
                .totalTax(entity.getTotalTax())
                .totalSale(entity.getTotalSale())
                .company(entity.getCompany() != null ? Company.builder().id(entity.getCompany().getId()).build() : null)
                .seller(entity.getSeller() != null ? User.builder().id(entity.getSeller().getId()).username(entity.getSeller().getUsername()).build() : null)
                .buyer(entity.getBuyer() != null ? User.builder().id(entity.getBuyer().getId()).build() : null)
                .status(entity.getStatus() != null ? ConfiguracionDet.builder().id(entity.getStatus().getId()).build() : null)
                .build();
    }

    private SaleHeaderEntity toEntity(SaleHeader domain) {
        if (domain == null) return null;
        return SaleHeaderEntity.builder()
                .id(domain.getId())
                .saleDate(domain.getSaleDate())
                .subtotal(domain.getSubtotal())
                .totalTax(domain.getTotalTax())
                .totalSale(domain.getTotalSale())
                .company(domain.getCompany() != null ? CompanyEntity.builder().id(domain.getCompany().getId()).build() : null)
                .seller(domain.getSeller() != null ? UserEntity.builder().id(domain.getSeller().getId()).build() : null)
                .buyer(domain.getBuyer() != null ? UserEntity.builder().id(domain.getBuyer().getId()).build() : null)
                .status(domain.getStatus() != null ? ConfiguracionDetEntity.builder().id(domain.getStatus().getId()).build() : null)
                .build();
    }
}