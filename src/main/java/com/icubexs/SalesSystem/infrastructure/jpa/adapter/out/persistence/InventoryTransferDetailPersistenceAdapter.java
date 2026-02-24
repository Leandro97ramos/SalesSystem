package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.application.port.out.InventoryTransferDetailRepository;
import com.icubexs.SalesSystem.domain.model.Batch;
import com.icubexs.SalesSystem.domain.model.InventoryTransfer;
import com.icubexs.SalesSystem.domain.model.InventoryTransferDetail;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.BatchEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.InventoryTransferDetailEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.InventoryTransferEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.InventoryTransferDetailJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InventoryTransferDetailPersistenceAdapter implements InventoryTransferDetailRepository {

    private final InventoryTransferDetailJpaRepository jpaRepository;

    @Override
    public InventoryTransferDetail save(InventoryTransferDetail domain) {
        return toDomain(jpaRepository.save(toEntity(domain)));
    }

    @Override
    public List<InventoryTransferDetail> findByTransferId(Long transferId) {
        return jpaRepository.findByInventoryTransferId(transferId).stream()
                .map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<InventoryTransferDetail> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private InventoryTransferDetail toDomain(InventoryTransferDetailEntity entity) {
        if (entity == null) return null;
        return InventoryTransferDetail.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .inventoryTransfer(entity.getInventoryTransfer() != null ?
                        InventoryTransfer.builder().id(entity.getInventoryTransfer().getId()).build() : null)
                .batch(entity.getBatch() != null ?
                        Batch.builder().id(entity.getBatch().getId()).code(entity.getBatch().getCode()).build() : null)
                .build();
    }

    private InventoryTransferDetailEntity toEntity(InventoryTransferDetail domain) {
        if (domain == null) return null;
        return InventoryTransferDetailEntity.builder()
                .id(domain.getId())
                .quantity(domain.getQuantity())
                .inventoryTransfer(domain.getInventoryTransfer() != null ?
                        InventoryTransferEntity.builder().id(domain.getInventoryTransfer().getId()).build() : null)
                .batch(domain.getBatch() != null ?
                        BatchEntity.builder().id(domain.getBatch().getId()).build() : null)
                .build();
    }
}