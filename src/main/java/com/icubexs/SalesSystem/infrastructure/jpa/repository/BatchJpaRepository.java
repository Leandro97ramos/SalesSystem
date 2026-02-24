package com.icubexs.SalesSystem.infrastructure.jpa.repository;


import com.icubexs.SalesSystem.infrastructure.jpa.entity.BatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BatchJpaRepository extends JpaRepository<BatchEntity, Long> {
    List<BatchEntity> findByProductId(Long productId);
    List<BatchEntity> findByCompanyId(Long companyId);
}