package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Long> {

    Optional<CompanyEntity> findByTaxId(String taxId);

}

