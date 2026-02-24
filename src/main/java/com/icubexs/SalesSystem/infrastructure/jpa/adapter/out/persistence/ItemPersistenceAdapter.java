package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.ItemRepository;
import com.icubexs.SalesSystem.domain.model.*;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.*;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.ItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ItemPersistenceAdapter implements ItemRepository {

    private final ItemJpaRepository jpaRepository;

    @Override
    public Item save(Item domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<Item> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Item> findBySerialNumber(String serialNumber) {
        return jpaRepository.findBySerialNumber(serialNumber).map(this::toDomain);
    }

    @Override
    public List<Item> findByProductId(Long productId) {
        return jpaRepository.findByProductId(productId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Item> findByBatchId(Long batchId) {
        return jpaRepository.findByBatchId(batchId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private Item toDomain(ItemEntity entity) {
        if (entity == null) return null;
        return Item.builder()
                .id(entity.getId())
                .serialNumber(entity.getSerialNumber())
                .product(entity.getProduct() != null ? Product.builder().id(entity.getProduct().getId()).build() : null)
                .batch(entity.getBatch() != null ? Batch.builder().id(entity.getBatch().getId()).build() : null)
                .status(entity.getStatus() != null ? ConfiguracionDet.builder().id(entity.getStatus().getId()).build() : null)
                .build();
    }

    private ItemEntity toEntity(Item domain) {
        if (domain == null) return null;
        return ItemEntity.builder()
                .id(domain.getId())
                .serialNumber(domain.getSerialNumber())
                .product(domain.getProduct() != null ? ProductEntity.builder().id(domain.getProduct().getId()).build() : null)
                .batch(domain.getBatch() != null ? BatchEntity.builder().id(domain.getBatch().getId()).build() : null)
                .status(domain.getStatus() != null ? ConfiguracionDetEntity.builder().id(domain.getStatus().getId()).build() : null)
                .build();
    }
}