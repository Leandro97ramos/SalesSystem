package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.BatchInfoService;
import com.icubexs.SalesSystem.application.port.out.BatchInfoRepository;
import com.icubexs.SalesSystem.domain.model.BatchInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchInfoServiceImpl implements BatchInfoService {

    private final BatchInfoRepository repository;

    @Override
    public BatchInfo save(BatchInfo batchInfo) {
        return repository.save(batchInfo);
    }

    @Override
    public Optional<BatchInfo> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<BatchInfo> findByBatchId(Long batchId) {
        return repository.findByBatchId(batchId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}