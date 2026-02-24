package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;


import com.icubexs.SalesSystem.application.port.out.SalePaymentRepository;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.domain.model.SaleHeader;
import com.icubexs.SalesSystem.domain.model.SalePayment;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.SaleHeaderEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.SalePaymentEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.SalePaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SalePaymentPersistenceAdapter implements SalePaymentRepository {

    private final SalePaymentJpaRepository jpaRepository;

    @Override
    public SalePayment save(SalePayment domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<SalePayment> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<SalePayment> findBySaleId(Long saleId) {
        return jpaRepository.findBySaleId(saleId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    private SalePayment toDomain(SalePaymentEntity entity) {
        if (entity == null) return null;
        return SalePayment.builder()
                .id(entity.getId())
                .amountPaid(entity.getAmountPaid())
                .transactionReference(entity.getTransactionReference())
                .sale(entity.getSale() != null ?
                        SaleHeader.builder().id(entity.getSale().getId()).build() : null)
                .paymentMethod(entity.getPaymentMethod() != null ?
                        ConfiguracionDet.builder().id(entity.getPaymentMethod().getId()).nombre(entity.getPaymentMethod().getNombre()).build() : null)
                .build();
    }

    private SalePaymentEntity toEntity(SalePayment domain) {
        if (domain == null) return null;
        return SalePaymentEntity.builder()
                .id(domain.getId())
                .amountPaid(domain.getAmountPaid())
                .transactionReference(domain.getTransactionReference())
                .sale(domain.getSale() != null ?
                        SaleHeaderEntity.builder().id(domain.getSale().getId()).build() : null)
                .paymentMethod(domain.getPaymentMethod() != null ?
                        ConfiguracionDetEntity.builder().id(domain.getPaymentMethod().getId()).build() : null)
                .build();
    }
}