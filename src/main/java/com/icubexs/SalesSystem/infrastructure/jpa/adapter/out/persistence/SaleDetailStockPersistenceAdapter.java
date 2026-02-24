package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.SaleDetailStockRepository;
import com.icubexs.SalesSystem.domain.model.*;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.*;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.SaleDetailStockJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SaleDetailStockPersistenceAdapter implements SaleDetailStockRepository {

    private final SaleDetailStockJpaRepository jpaRepository;

    @Override
    public SaleDetailStock save(SaleDetailStock domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public List<SaleDetailStock> findBySaleDetailId(Long saleDetailId) {
        return jpaRepository.findBySaleDetailId(saleDetailId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<SaleDetailStock> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    private SaleDetailStock toDomain(SaleDetailStockEntity entity) {
        if (entity == null) return null;
        return SaleDetailStock.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .saleDetail(SaleDetail.builder().id(entity.getSaleDetail().getId()).build())
                .stock(Stock.builder().id(entity.getStock().getId()).build())
                .item(entity.getItem() != null ? Item.builder().id(entity.getItem().getId()).serialNumber(entity.getItem().getSerialNumber()).build() : null)
                .build();
    }

    private SaleDetailStockEntity toEntity(SaleDetailStock domain) {
        if (domain == null) return null;
        return SaleDetailStockEntity.builder()
                .id(domain.getId())
                .quantity(domain.getQuantity())
                .saleDetail(SaleDetailEntity.builder().id(domain.getSaleDetail().getId()).build())
                .stock(StockEntity.builder().id(domain.getStock().getId()).build())
                .item(domain.getItem() != null ? ItemEntity.builder().id(domain.getItem().getId()).build() : null)
                .build();
    }
}