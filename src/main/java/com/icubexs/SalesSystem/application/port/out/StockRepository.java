package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Stock;
import java.util.List;
import java.util.Optional;

public interface StockRepository {
    Stock save(Stock stock);
    Optional<Stock> findById(Long id);
    List<Stock> findByProductId(Long productId);
    List<Stock> findByBatchId(Long batchId);
    List<Stock> findAll();
}