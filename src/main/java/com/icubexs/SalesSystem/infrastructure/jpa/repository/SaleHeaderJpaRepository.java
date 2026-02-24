package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.SaleHeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleHeaderJpaRepository extends JpaRepository<SaleHeaderEntity, Long> {
    List<SaleHeaderEntity> findBySellerId(Long sellerId);
}