package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.SaleDetail;
import java.util.List;
import java.util.Optional;

public interface SaleDetailService {
    SaleDetail addDetail(SaleDetail detail);
    List<SaleDetail> findBySaleId(Long saleId);
    void removeDetail(Long id);
}