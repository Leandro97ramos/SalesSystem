package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.SaleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleDetailJpaRepository extends JpaRepository<SaleDetailEntity, Long> {
    List<SaleDetailEntity> findBySaleId(Long saleId);
}
