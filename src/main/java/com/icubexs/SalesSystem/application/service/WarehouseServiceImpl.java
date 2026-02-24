package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.WarehouseService;
import com.icubexs.SalesSystem.application.port.out.WarehouseRepository;
import com.icubexs.SalesSystem.domain.model.Warehouse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository repository;

    @Override
    public Warehouse save(Warehouse warehouse) {
        return repository.save(warehouse);
    }

    @Override
    public Optional<Warehouse> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Warehouse> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Warehouse> findByCompanyId(Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}