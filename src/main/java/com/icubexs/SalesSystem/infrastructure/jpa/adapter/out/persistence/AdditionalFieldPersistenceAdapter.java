package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.AdditionalFieldRepository;
import com.icubexs.SalesSystem.domain.model.AdditionalField;
import com.icubexs.SalesSystem.domain.model.ConfiguracionDet;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.AdditionalFieldEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ConfiguracionDetEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.AdditionalFieldJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdditionalFieldPersistenceAdapter implements AdditionalFieldRepository {

    private final AdditionalFieldJpaRepository jpaRepository;

    @Override
    public AdditionalField save(AdditionalField domain) {
        AdditionalFieldEntity entity = toEntity(domain);
        return toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<AdditionalField> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<AdditionalField> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    // --- MAPEO MANUAL ---
    private AdditionalField toDomain(AdditionalFieldEntity entity) {
        if (entity == null) return null;
        return AdditionalField.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .attribute(entity.getAttribute())
                .dataSource(entity.getDataSource() != null ?
                        ConfiguracionDet.builder().id(entity.getDataSource().getId()).build() : null)
                .dataType(entity.getDataType() != null ?
                        ConfiguracionDet.builder().id(entity.getDataType().getId()).build() : null)
                .build();
    }

    private AdditionalFieldEntity toEntity(AdditionalField domain) {
        if (domain == null) return null;
        return AdditionalFieldEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .description(domain.getDescription())
                .attribute(domain.getAttribute())
                .dataSource(domain.getDataSource() != null ?
                        ConfiguracionDetEntity.builder().id(domain.getDataSource().getId()).build() : null)
                .dataType(domain.getDataType() != null ?
                        ConfiguracionDetEntity.builder().id(domain.getDataType().getId()).build() : null)
                .build();
    }
}