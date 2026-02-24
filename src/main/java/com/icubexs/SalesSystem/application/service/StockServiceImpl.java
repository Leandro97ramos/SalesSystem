package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.StockService;
import com.icubexs.SalesSystem.application.port.out.StockRepository;
import com.icubexs.SalesSystem.domain.model.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository repository;

    @Override
    public Stock save(Stock stock) {
        return repository.save(stock);
    }

    @Override
    public Optional<Stock> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Stock> findByProductId(Long productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public List<Stock> findByBatchId(Long batchId) {
        return repository.findByBatchId(batchId);
    }

    @Override
    public List<Stock> findAll() {
        return repository.findAll();
    }
}