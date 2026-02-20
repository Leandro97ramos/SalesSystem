package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Batch;
import java.util.Optional;

public interface BatchRepository {
    Batch save(Batch batch);
    Optional<Batch> findById(Long id);
}