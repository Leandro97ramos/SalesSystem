package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Warehouse;
import java.util.Optional;

public interface WarehouseRepository {
    Warehouse save(Warehouse warehouse);
    Optional<Warehouse> findById(Long id);
}