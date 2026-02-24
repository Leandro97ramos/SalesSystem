package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.BatchInfo;
import java.util.List;
import java.util.Optional;

public interface BatchInfoService {
    BatchInfo save(BatchInfo batchInfo);
    Optional<BatchInfo> findById(Long id);
    List<BatchInfo> findByBatchId(Long batchId);
    void deleteById(Long id);
}