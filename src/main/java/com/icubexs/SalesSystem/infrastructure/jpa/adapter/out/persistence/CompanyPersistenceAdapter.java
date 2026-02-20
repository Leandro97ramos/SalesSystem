package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.application.port.out.CompanyRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.CompanyEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.CompanyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CompanyPersistenceAdapter implements CompanyRepository {
    private final CompanyJpaRepository jpaRepository;

    @Override
    public Company save(Company company) {
        CompanyEntity entity = new CompanyEntity();
        entity.setLegalName(company.getLegalName());
        entity.setTaxId(company.getTaxId());
        entity.setGlobalConfig(company.getGlobalConfig());

        CompanyEntity saved = jpaRepository.save(entity);
        return new Company(saved.getCompanyId(), saved.getLegalName(),
                saved.getTaxId(), saved.getGlobalConfig());
    }

    @Override
    public Optional<Company> findById(Long id) {
        return jpaRepository.findById(id)
                .map(e -> new Company(e.getCompanyId(), e.getLegalName(),
                        e.getTaxId(), e.getGlobalConfig()));
    }
}