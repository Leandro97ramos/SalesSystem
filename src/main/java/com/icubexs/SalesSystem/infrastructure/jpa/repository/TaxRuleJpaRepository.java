package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.TaxRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaxRuleJpaRepository extends JpaRepository<TaxRuleEntity, Long> {
    List<TaxRuleEntity> findByGeoLocationId(Long geoLocationId);
}