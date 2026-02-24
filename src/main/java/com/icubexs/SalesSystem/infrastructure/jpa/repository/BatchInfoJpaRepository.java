package com.icubexs.SalesSystem.infrastructure.jpa.repository;


import com.icubexs.SalesSystem.infrastructure.jpa.entity.BatchInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BatchInfoJpaRepository extends JpaRepository<BatchInfoEntity, Long> {
    List<BatchInfoEntity> findByBatchId(Long batchId);
}
