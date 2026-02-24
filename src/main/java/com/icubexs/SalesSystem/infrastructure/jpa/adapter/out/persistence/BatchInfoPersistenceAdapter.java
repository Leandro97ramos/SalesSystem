package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.BatchInfoRepository;
import com.icubexs.SalesSystem.domain.model.AdditionalField;
import com.icubexs.SalesSystem.domain.model.BatchInfo;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.AdditionalFieldEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.BatchInfoEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.BatchInfoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BatchInfoPersistenceAdapter implements BatchInfoRepository {

    private final BatchInfoJpaRepository jpaRepository;

    @Override
    public BatchInfo save(BatchInfo domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<BatchInfo> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<BatchInfo> findByBatchId(Long batchId) {
        return jpaRepository.findByBatchId(batchId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private BatchInfo toDomain(BatchInfoEntity entity) {
        if (entity == null) return null;
        return BatchInfo.builder()
                .id(entity.getId())
                .batchId(entity.getBatchId())
                .value(entity.getValue())
                .additionalField(entity.getAdditionalField() != null ?
                        AdditionalField.builder().id(entity.getAdditionalField().getId()).build() : null)
                .build();
    }

    private BatchInfoEntity toEntity(BatchInfo domain) {
        if (domain == null) return null;
        return BatchInfoEntity.builder()
                .id(domain.getId())
                .batchId(domain.getBatchId())
                .value(domain.getValue())
                .additionalField(domain.getAdditionalField() != null ?
                        AdditionalFieldEntity.builder().id(domain.getAdditionalField().getId()).build() : null)
                .build();
    }
}