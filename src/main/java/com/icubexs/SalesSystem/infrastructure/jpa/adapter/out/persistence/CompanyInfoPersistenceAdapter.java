package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.CompanyInfoRepository;
import com.icubexs.SalesSystem.domain.model.AdditionalField;
import com.icubexs.SalesSystem.domain.model.CompanyInfo;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.AdditionalFieldEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.CompanyInfoEntity;

import com.icubexs.SalesSystem.infrastructure.jpa.repository.CompanyInfoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyInfoPersistenceAdapter implements CompanyInfoRepository {

    private final CompanyInfoJpaRepository jpaRepository;

    @Override
    public CompanyInfo save(CompanyInfo domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public List<CompanyInfo> findByCompanyId(Long companyId) {
        return jpaRepository.findByCompanyId(companyId).stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<CompanyInfo> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public void deleteById(Long id) { jpaRepository.deleteById(id); }

    private CompanyInfo toDomain(CompanyInfoEntity entity) {
        if (entity == null) return null;
        return CompanyInfo.builder()
                .id(entity.getId())
                .companyId(entity.getCompanyId())
                .value(entity.getValue())
                .additionalField(entity.getAdditionalField() != null ?
                        AdditionalField.builder().id(entity.getAdditionalField().getId()).build() : null)
                .build();
    }

    private CompanyInfoEntity toEntity(CompanyInfo domain) {
        if (domain == null) return null;
        return CompanyInfoEntity.builder()
                .id(domain.getId())
                .companyId(domain.getCompanyId())
                .value(domain.getValue())
                .additionalField(domain.getAdditionalField() != null ?
                        AdditionalFieldEntity.builder().id(domain.getAdditionalField().getId()).build() : null)
                .build();
    }
}