package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.InventoryTransferDetailService;
import com.icubexs.SalesSystem.application.port.out.InventoryTransferDetailRepository;
import com.icubexs.SalesSystem.domain.model.InventoryTransferDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryTransferDetailServiceImpl implements InventoryTransferDetailService {

    private final InventoryTransferDetailRepository repository;

    @Override
    public InventoryTransferDetail save(InventoryTransferDetail detail) {
        return repository.save(detail);
    }

    @Override
    public List<InventoryTransferDetail> findByTransferId(Long transferId) {
        return repository.findByTransferId(transferId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}