package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.domain.model.Warehouse;
import com.icubexs.SalesSystem.application.port.out.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    public Warehouse createWarehouse(Warehouse warehouse) {
        // Aquí se validará que la empresa y localidad existan antes de guardar
        return warehouseRepository.save(warehouse);
    }
}