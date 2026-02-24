package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.SaleDetailService;
import com.icubexs.SalesSystem.application.port.out.SaleDetailRepository;
import com.icubexs.SalesSystem.domain.model.SaleDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleDetailServiceImpl implements SaleDetailService {

    private final SaleDetailRepository repository;

    @Override
    public SaleDetail addDetail(SaleDetail detail) {
        // Aquí podrías agregar lógica para recalcular el 'total'
        // antes de guardar si el frontend no lo envía calculado.
        return repository.save(detail);
    }

    @Override
    public List<SaleDetail> findBySaleId(Long saleId) {
        return repository.findBySaleId(saleId);
    }

    @Override
    public void removeDetail(Long id) {
        repository.deleteById(id);
    }
}