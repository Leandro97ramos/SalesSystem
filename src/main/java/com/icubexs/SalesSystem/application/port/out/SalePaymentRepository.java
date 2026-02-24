package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.SalePayment;
import java.util.List;
import java.util.Optional;

public interface SalePaymentRepository {
    SalePayment save(SalePayment payment);
    Optional<SalePayment> findById(Long id);
    List<SalePayment> findBySaleId(Long saleId);
}
