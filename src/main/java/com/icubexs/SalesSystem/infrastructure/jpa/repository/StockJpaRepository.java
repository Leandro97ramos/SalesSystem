package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StockJpaRepository extends JpaRepository<StockEntity, Long> {
    List<StockEntity> findByProductId(Long productId);
    List<StockEntity> findByBatchId(Long batchId);
}