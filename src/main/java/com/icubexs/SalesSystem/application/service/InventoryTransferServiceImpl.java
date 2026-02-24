package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.InventoryTransferService;
import com.icubexs.SalesSystem.application.port.out.InventoryTransferRepository;
import com.icubexs.SalesSystem.domain.model.InventoryTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryTransferServiceImpl implements InventoryTransferService {

    private final InventoryTransferRepository repository;

    @Override
    public InventoryTransfer createTransfer(InventoryTransfer transfer) {
        return repository.save(transfer);
    }

    @Override
    public Optional<InventoryTransfer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<InventoryTransfer> findAll() {
        return repository.findAll();
    }

    @Override
    public List<InventoryTransfer> findBySourceWarehouse(Long warehouseId) {
        return repository.findBySourceWarehouseId(warehouseId);
    }
}