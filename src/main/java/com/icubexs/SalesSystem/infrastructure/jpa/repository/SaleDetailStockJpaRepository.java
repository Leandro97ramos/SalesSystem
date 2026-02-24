package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.SaleDetailStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleDetailStockJpaRepository extends JpaRepository<SaleDetailStockEntity, Long> {
    List<SaleDetailStockEntity> findBySaleDetailId(Long saleDetailId);
}