package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.BatchService;
import com.icubexs.SalesSystem.application.port.out.BatchRepository;
import com.icubexs.SalesSystem.domain.model.Batch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private final BatchRepository repository;

    @Override
    public Batch save(Batch batch) {
        return repository.save(batch);
    }

    @Override
    public Optional<Batch> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Batch> findByProductId(Long productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public List<Batch> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}