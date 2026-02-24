package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WarehouseJpaRepository extends JpaRepository<WarehouseEntity, Long> {
    List<WarehouseEntity> findByCompanyId(Long companyId);
}