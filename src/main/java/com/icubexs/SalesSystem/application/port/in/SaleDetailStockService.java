package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.SaleDetailStock;
import java.util.List;

public interface SaleDetailStockService {
    SaleDetailStock save(SaleDetailStock detailStock);
    List<SaleDetailStock> findBySaleDetailId(Long saleDetailId);
}