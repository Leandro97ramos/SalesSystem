package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.application.port.in.ItemService;
import com.icubexs.SalesSystem.application.port.out.ItemRepository;
import com.icubexs.SalesSystem.domain.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Item> findBySerialNumber(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<Item> findByProductId(Long productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public List<Item> findByBatchId(Long batchId) {
        return repository.findByBatchId(batchId);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}