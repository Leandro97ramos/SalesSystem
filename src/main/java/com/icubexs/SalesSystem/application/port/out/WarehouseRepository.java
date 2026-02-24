package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Warehouse;
import java.util.List;
import java.util.Optional;

public interface WarehouseRepository {
    Warehouse save(Warehouse warehouse);
    Optional<Warehouse> findById(Long id);
    List<Warehouse> findAll();
    List<Warehouse> findByCompanyId(Long companyId);
    void deleteById(Long id);
}