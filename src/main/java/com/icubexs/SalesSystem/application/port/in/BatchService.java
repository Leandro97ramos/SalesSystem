package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.Batch;
import java.util.List;
import java.util.Optional;

public interface BatchService {
    Batch save(Batch batch);
    Optional<Batch> findById(Long id);
    List<Batch> findByProductId(Long productId);
    List<Batch> findByCompanyId(Long companyId);
    void deleteById(Long id);
}