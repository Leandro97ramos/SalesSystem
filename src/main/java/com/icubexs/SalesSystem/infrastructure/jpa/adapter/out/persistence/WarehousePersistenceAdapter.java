package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.domain.model.Warehouse;
import com.icubexs.SalesSystem.application.port.out.WarehouseRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.WarehouseEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.WarehouseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehousePersistenceAdapter implements WarehouseRepository {
    private final WarehouseJpaRepository jpaRepository;

    @Override
    public Warehouse save(Warehouse warehouse) {
        WarehouseEntity entity = new WarehouseEntity();
        entity.setCompanyId(warehouse.getCompanyId());
        entity.setLocationId(warehouse.getLocationId());
        entity.setConfigHeaderId(warehouse.getConfigHeaderId());
        entity.setName(warehouse.getName());
        entity.setAddress(warehouse.getAddress());

        WarehouseEntity saved = jpaRepository.save(entity);
        return new Warehouse(saved.getWarehouseId(), saved.getCompanyId(),
                saved.getLocationId(), saved.getConfigHeaderId(),
                saved.getName(), saved.getAddress());
    }

    @Override
    public java.util.Optional<Warehouse> findById(Long id) {
        return jpaRepository.findById(id)
                .map(e -> new Warehouse(e.getWarehouseId(), e.getCompanyId(),
                        e.getLocationId(), e.getConfigHeaderId(),
                        e.getName(), e.getAddress()));
    }
}