package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.ProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductInfoJpaRepository extends JpaRepository<ProductInfoEntity, Long> {
    List<ProductInfoEntity> findByProductId(Long productId);
}