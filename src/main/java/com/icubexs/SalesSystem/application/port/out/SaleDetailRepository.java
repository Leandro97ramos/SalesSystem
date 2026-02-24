package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.SaleDetail;
import java.util.List;
import java.util.Optional;

public interface SaleDetailRepository {
    SaleDetail save(SaleDetail detail);
    Optional<SaleDetail> findById(Long id);
    List<SaleDetail> findBySaleId(Long saleId);
    void deleteById(Long id);
}
