package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.StockRepository;
import com.icubexs.SalesSystem.domain.model.*;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.*;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.StockJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StockPersistenceAdapter implements StockRepository {

    private final StockJpaRepository jpaRepository;

    @Override
    public Stock save(Stock domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<Stock> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Stock> findByProductId(Long productId) {
        return jpaRepository.findByProductId(productId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Stock> findByBatchId(Long batchId) {
        return jpaRepository.findByBatchId(batchId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Stock> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    private Stock toDomain(StockEntity entity) {
        if (entity == null) return null;
        return Stock.builder()
                .id(entity.getId())
                .currentQuantity(entity.getCurrentQuantity())
                .batch(entity.getBatch() != null ? Batch.builder().id(entity.getBatch().getId()).build() : null)
                .product(entity.getProduct() != null ? Product.builder().id(entity.getProduct().getId()).build() : null)
                .location(entity.getLocation() != null ? ConfiguracionDet.builder().id(entity.getLocation().getId()).build() : null)
                .build();
    }

    private StockEntity toEntity(Stock domain) {
        if (domain == null) return null;
        return StockEntity.builder()
                .id(domain.getId())
                .currentQuantity(domain.getCurrentQuantity())
                .batch(domain.getBatch() != null ? BatchEntity.builder().id(domain.getBatch().getId()).build() : null)
                .product(domain.getProduct() != null ? ProductEntity.builder().id(domain.getProduct().getId()).build() : null)
                .location(domain.getLocation() != null ? ConfiguracionDetEntity.builder().id(domain.getLocation().getId()).build() : null)
                .build();
    }
}