package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.InventoryTransferRepository;
import com.icubexs.SalesSystem.domain.model.*;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.*;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.InventoryTransferJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InventoryTransferPersistenceAdapter implements InventoryTransferRepository {

    private final InventoryTransferJpaRepository jpaRepository;

    @Override
    public InventoryTransfer save(InventoryTransfer domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public Optional<InventoryTransfer> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<InventoryTransfer> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<InventoryTransfer> findBySourceWarehouseId(Long warehouseId) {
        return jpaRepository.findBySourceWarehouseId(warehouseId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    private InventoryTransfer toDomain(InventoryTransferEntity entity) {
        if (entity == null) return null;
        return InventoryTransfer.builder()
                .id(entity.getId())
                .transferDate(entity.getTransferDate())
                .description(entity.getDescription())
                .sourceWarehouse(entity.getSourceWarehouse() != null ? Warehouse.builder().id(entity.getSourceWarehouse().getId()).name(entity.getSourceWarehouse().getName()).build() : null)
                .destinationWarehouse(entity.getDestinationWarehouse() != null ? Warehouse.builder().id(entity.getDestinationWarehouse().getId()).name(entity.getDestinationWarehouse().getName()).build() : null)
                .user(entity.getUser() != null ? User.builder().id(entity.getUser().getId()).username(entity.getUser().getUsername()).build() : null)
                .status(entity.getStatus() != null ? ConfiguracionDet.builder().id(entity.getStatus().getId()).nombre(entity.getStatus().getNombre()).build() : null)
                .build();
    }

    private InventoryTransferEntity toEntity(InventoryTransfer domain) {
        if (domain == null) return null;
        return InventoryTransferEntity.builder()
                .id(domain.getId())
                .transferDate(domain.getTransferDate())
                .description(domain.getDescription())
                .sourceWarehouse(domain.getSourceWarehouse() != null ? WarehouseEntity.builder().id(domain.getSourceWarehouse().getId()).build() : null)
                .destinationWarehouse(domain.getDestinationWarehouse() != null ? WarehouseEntity.builder().id(domain.getDestinationWarehouse().getId()).build() : null)
                .user(domain.getUser() != null ? UserEntity.builder().id(domain.getUser().getId()).build() : null)
                .status(domain.getStatus() != null ? ConfiguracionDetEntity.builder().id(domain.getStatus().getId()).build() : null)
                .build();
    }
}