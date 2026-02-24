package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.SaleDetailStock;
import java.util.List;
import java.util.Optional;

public interface SaleDetailStockRepository {
    SaleDetailStock save(SaleDetailStock detailStock);
    List<SaleDetailStock> findBySaleDetailId(Long saleDetailId);
    Optional<SaleDetailStock> findById(Long id);
}