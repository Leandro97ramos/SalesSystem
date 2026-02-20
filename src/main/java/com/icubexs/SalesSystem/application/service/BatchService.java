package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.domain.model.Batch;
import com.icubexs.SalesSystem.application.port.out.BatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final BatchRepository batchRepository;

    public Batch registerBatch(Batch batch) {
        // En el futuro: Validar que el itemId exista antes de crear el lote
        // Validar que la expiryDate sea posterior a la entryDate
        return batchRepository.save(batch);
    }

}
