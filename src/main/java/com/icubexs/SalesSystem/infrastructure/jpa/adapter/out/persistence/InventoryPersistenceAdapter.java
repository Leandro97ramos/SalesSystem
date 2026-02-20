package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.domain.model.Inventory;
import com.icubexs.SalesSystem.application.port.out.InventoryRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.InventoryEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.InventoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryPersistenceAdapter implements InventoryRepository {
    private final InventoryJpaRepository jpaRepository;

    @Override
    public Inventory save(Inventory inventory) {
        InventoryEntity entity = new InventoryEntity();
        entity.setBatchId(inventory.getBatchId());
        entity.setConfigDetailId(inventory.getConfigDetailId());
        entity.setCurrentQuantity(inventory.getCurrentQuantity());

        InventoryEntity saved = jpaRepository.save(entity);
        return new Inventory(saved.getInventoryId(), saved.getBatchId(),
                saved.getConfigDetailId(), saved.getCurrentQuantity());
    }

    @Override
    public java.util.Optional<Inventory> findById(Long id) {
        return jpaRepository.findById(id)
                .map(e -> new Inventory(e.getInventoryId(), e.getBatchId(),
                        e.getConfigDetailId(), e.getCurrentQuantity()));
    }
}