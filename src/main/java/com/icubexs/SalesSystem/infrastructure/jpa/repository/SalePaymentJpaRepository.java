package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.SalePaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SalePaymentJpaRepository extends JpaRepository<SalePaymentEntity, Long> {
    List<SalePaymentEntity> findBySaleId(Long saleId);
}