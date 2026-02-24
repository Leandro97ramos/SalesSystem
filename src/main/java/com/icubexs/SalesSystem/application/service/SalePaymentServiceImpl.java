package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.SalePaymentService;
import com.icubexs.SalesSystem.application.port.out.SalePaymentRepository;
import com.icubexs.SalesSystem.domain.model.SalePayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalePaymentServiceImpl implements SalePaymentService {

    private final SalePaymentRepository repository;

    @Override
    public SalePayment registerPayment(SalePayment payment) {
        return repository.save(payment);
    }

    @Override
    public Optional<SalePayment> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SalePayment> findBySaleId(Long saleId) {
        return repository.findBySaleId(saleId);
    }
}