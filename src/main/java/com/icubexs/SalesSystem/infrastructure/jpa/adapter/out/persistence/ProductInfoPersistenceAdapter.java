package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.ProductInfoRepository;
import com.icubexs.SalesSystem.domain.model.AdditionalField;
import com.icubexs.SalesSystem.domain.model.ProductInfo;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.AdditionalFieldEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ProductInfoEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.ProductInfoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductInfoPersistenceAdapter implements ProductInfoRepository {

    private final ProductInfoJpaRepository jpaRepository;

    @Override
    public ProductInfo save(ProductInfo domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<ProductInfo> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<ProductInfo> findByProductId(Long productId) {
        return jpaRepository.findByProductId(productId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private ProductInfo toDomain(ProductInfoEntity entity) {
        if (entity == null) return null;
        return ProductInfo.builder()
                .id(entity.getId())
                .productId(entity.getProductId())
                .value(entity.getValue())
                .additionalField(entity.getAdditionalField() != null ?
                        AdditionalField.builder().id(entity.getAdditionalField().getId()).build() : null)
                .build();
    }

    private ProductInfoEntity toEntity(ProductInfo domain) {
        if (domain == null) return null;
        return ProductInfoEntity.builder()
                .id(domain.getId())
                .productId(domain.getProductId())
                .value(domain.getValue())
                .additionalField(domain.getAdditionalField() != null ?
                        AdditionalFieldEntity.builder().id(domain.getAdditionalField().getId()).build() : null)
                .build();
    }
}