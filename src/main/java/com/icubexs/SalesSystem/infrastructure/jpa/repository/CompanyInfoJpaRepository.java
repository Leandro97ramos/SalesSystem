package com.icubexs.SalesSystem.infrastructure.jpa.repository;

import com.icubexs.SalesSystem.infrastructure.jpa.entity.CompanyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyInfoJpaRepository extends JpaRepository<CompanyInfoEntity, Long> {

    /**
     * Busca todos los valores de configuración dinámica asociados a una empresa específica.
     * @param companyId ID de la empresa (entity_id en el script SQL)
     */
    List<CompanyInfoEntity> findByCompanyId(Long companyId);
}