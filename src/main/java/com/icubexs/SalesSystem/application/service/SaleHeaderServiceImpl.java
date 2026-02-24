package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.SaleHeaderService;
import com.icubexs.SalesSystem.application.port.out.SaleHeaderRepository;
import com.icubexs.SalesSystem.domain.model.SaleHeader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleHeaderServiceImpl implements SaleHeaderService {

    private final SaleHeaderRepository repository;

    @Override
    public SaleHeader createSale(SaleHeader saleHeader) {
        return repository.save(saleHeader);
    }

    @Override
    public Optional<SaleHeader> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<SaleHeader> findAll() {
        return repository.findAll();
    }

    @Override
    public List<SaleHeader> findBySellerId(Long sellerId) {
        return repository.findBySellerId(sellerId);
    }
}