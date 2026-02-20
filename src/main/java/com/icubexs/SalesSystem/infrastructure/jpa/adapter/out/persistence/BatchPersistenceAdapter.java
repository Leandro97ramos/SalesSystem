package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;


import com.icubexs.SalesSystem.domain.model.Batch;
import com.icubexs.SalesSystem.application.port.out.BatchRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.BatchEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.BatchJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BatchPersistenceAdapter implements BatchRepository {
    private final BatchJpaRepository batchJpaRepository;

    @Override
    public Batch save(Batch batch) {
        BatchEntity entity = new BatchEntity();
        entity.setItemId(batch.getItemId()); // [cite: 182]
        entity.setBatchCode(batch.getBatchCode()); // [cite: 183]
        entity.setEntryDate(batch.getEntryDate()); // [cite: 184]
        entity.setExpiryDate(batch.getExpiryDate()); // [cite: 185]
        entity.setProviderId(batch.getProviderId()); // [cite: 186]

        BatchEntity saved = batchJpaRepository.save(entity);
        return new Batch(
                saved.getBatchId(), saved.getItemId(), saved.getBatchCode(),
                saved.getEntryDate(), saved.getExpiryDate(), saved.getProviderId()
        );
    }

    //Sin uso
    @Override
    public Optional<Batch> findById(Long id) {
        return Optional.empty();
    }
}
