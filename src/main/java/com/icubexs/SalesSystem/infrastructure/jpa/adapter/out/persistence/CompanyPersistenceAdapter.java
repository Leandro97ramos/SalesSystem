package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;


import com.icubexs.SalesSystem.application.port.out.CompanyRepository;
import com.icubexs.SalesSystem.domain.model.Company;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.CompanyEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.CompanyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyPersistenceAdapter implements CompanyRepository {

    private final CompanyJpaRepository jpaRepository;

    @Override
    public Company save(Company domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<Company> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<Company> findByTaxId(String taxId) {
        return jpaRepository.findByTaxIdNumber(taxId).map(this::toDomain);
    }

    @Override
    public List<Company> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {

        jpaRepository.deleteById(id);

    }

    @Override
    public List<Company> findByParentId(Long parentId) {
        return jpaRepository.findByParentCompanyId(parentId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private Company toDomain(CompanyEntity entity) {
        if (entity == null) return null;
        return Company.builder()
                .id(entity.getId())
                .taxIdNumber(entity.getTaxIdNumber())
                .legalName(entity.getLegalName())
                .parentCompany(entity.getParentCompany() != null ?
                        Company.builder().id(entity.getParentCompany().getId()).build() : null)
                .typeConfiguration(entity.getTypeConfiguration() != null ?
                        ConfiguracionDet.builder().id(entity.getTypeConfiguration().getId()).build() : null)
                .build();
    }

    private CompanyEntity toEntity(Company domain) {
        if (domain == null) return null;
        return CompanyEntity.builder()
                .id(domain.getId())
                .taxIdNumber(domain.getTaxIdNumber())
                .legalName(domain.getLegalName())
                .parentCompany(domain.getParentCompany() != null ?
                        CompanyEntity.builder().id(domain.getParentCompany().getId()).build() : null)
                .typeConfiguration(domain.getTypeConfiguration() != null ?
                        ConfiguracionDetEntity.builder().id(domain.getTypeConfiguration().getId()).build() : null)
                .build();
    }


}