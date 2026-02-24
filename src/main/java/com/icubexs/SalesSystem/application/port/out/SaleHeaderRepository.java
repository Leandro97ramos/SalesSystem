package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.SaleHeader;
import java.util.List;
import java.util.Optional;

public interface SaleHeaderRepository {
    SaleHeader save(SaleHeader saleHeader);
    Optional<SaleHeader> findById(Long id);
    List<SaleHeader> findAll();
    List<SaleHeader> findBySellerId(Long sellerId);
}