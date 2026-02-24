package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.SaleDetailStockService;
import com.icubexs.SalesSystem.application.port.out.SaleDetailStockRepository;
import com.icubexs.SalesSystem.domain.model.SaleDetailStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleDetailStockServiceImpl implements SaleDetailStockService {

    private final SaleDetailStockRepository repository;

    @Override
    public SaleDetailStock save(SaleDetailStock detailStock) {
        return repository.save(detailStock);
    }

    @Override
    public List<SaleDetailStock> findBySaleDetailId(Long saleDetailId) {
        return repository.findBySaleDetailId(saleDetailId);
    }
}