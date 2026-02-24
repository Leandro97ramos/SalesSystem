package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.SalePayment;
import java.util.List;
import java.util.Optional;

public interface SalePaymentService {
    SalePayment registerPayment(SalePayment payment);
    Optional<SalePayment> findById(Long id);
    List<SalePayment> findBySaleId(Long saleId);
}