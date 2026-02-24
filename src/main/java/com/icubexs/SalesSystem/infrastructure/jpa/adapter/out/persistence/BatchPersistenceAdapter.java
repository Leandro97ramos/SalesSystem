package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;


import com.icubexs.SalesSystem.application.port.out.BatchRepository;
import com.icubexs.SalesSystem.domain.model.Batch;
import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.Product;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.BatchEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.CompanyEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ProductEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.BatchJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BatchPersistenceAdapter implements BatchRepository {

    private final BatchJpaRepository jpaRepository;

    @Override
    public Batch save(Batch domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<Batch> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Batch> findByProductId(Long productId) {
        return jpaRepository.findByProductId(productId).stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Batch> findByCompanyId(Long companyId) {
        return jpaRepository.findByCompanyId(companyId).stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private Batch toDomain(BatchEntity entity) {
        if (entity == null) return null;
        return Batch.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .invoiceNumber(entity.getInvoiceNumber())
                .initialQuantity(entity.getInitialQuantity())
                .currentQuantity(entity.getCurrentQuantity())
                .entryDate(entity.getEntryDate())
                .expirationDate(entity.getExpirationDate())
                .unitCost(entity.getUnitCost())
                .product(entity.getProduct() != null ? Product.builder().id(entity.getProduct().getId()).build() : null)
                .company(entity.getCompany() != null ? Company.builder().id(entity.getCompany().getId()).build() : null)
                .build();
    }

    private BatchEntity toEntity(Batch domain) {
        if (domain == null) return null;
        return BatchEntity.builder()
                .id(domain.getId())
                .code(domain.getCode())
                .invoiceNumber(domain.getInvoiceNumber())
                .initialQuantity(domain.getInitialQuantity())
                .currentQuantity(domain.getCurrentQuantity())
                .entryDate(domain.getEntryDate())
                .expirationDate(domain.getExpirationDate())
                .unitCost(domain.getUnitCost())
                .product(domain.getProduct() != null ? ProductEntity.builder().id(domain.getProduct().getId()).build() : null)
                .company(domain.getCompany() != null ? CompanyEntity.builder().id(domain.getCompany().getId()).build() : null)
                .build();
    }
}
