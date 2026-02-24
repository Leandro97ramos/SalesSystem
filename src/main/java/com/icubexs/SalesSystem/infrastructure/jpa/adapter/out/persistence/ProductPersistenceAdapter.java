package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.ProductRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.Product;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ProductEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductRepository {

    private final ProductJpaRepository jpaRepository;

    @Override
    public Product save(Product domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Product> findBySku(String sku) {
        return jpaRepository.findBySku(sku).map(this::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private Product toDomain(ProductEntity entity) {
        if (entity == null) return null;
        return Product.builder()
                .id(entity.getId())
                .sku(entity.getSku())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .isSerialized(entity.getIsSerialized())
                .appliesTax(entity.getAppliesTax())
                .length(entity.getLength())
                .width(entity.getWidth())
                .height(entity.getHeight())
                .measureValue(entity.getMeasureValue())
                .basePrice(entity.getBasePrice())
                .unitMeasure(entity.getUnitMeasure() != null ?
                        ConfiguracionDet.builder().id(entity.getUnitMeasure().getId()).nombre(entity.getUnitMeasure().getNombre()).build() : null)
                .taxCategory(entity.getTaxCategory() != null ?
                        ConfiguracionDet.builder().id(entity.getTaxCategory().getId()).nombre(entity.getTaxCategory().getNombre()).build() : null)
                .build();
    }

    private ProductEntity toEntity(Product domain) {
        if (domain == null) return null;
        return ProductEntity.builder()
                .id(domain.getId())
                .sku(domain.getSku())
                .code(domain.getCode())
                .name(domain.getName())
                .description(domain.getDescription())
                .isSerialized(domain.getIsSerialized())
                .appliesTax(domain.getAppliesTax())
                .length(domain.getLength())
                .width(domain.getWidth())
                .height(domain.getHeight())
                .measureValue(domain.getMeasureValue())
                .basePrice(domain.getBasePrice())
                .unitMeasure(domain.getUnitMeasure() != null ?
                        ConfiguracionDetEntity.builder().id(domain.getUnitMeasure().getId()).build() : null)
                .taxCategory(domain.getTaxCategory() != null ?
                        ConfiguracionDetEntity.builder().id(domain.getTaxCategory().getId()).build() : null)
                .build();
    }
}