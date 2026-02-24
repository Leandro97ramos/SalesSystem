package com.icubexs.SalesSystem.application.port.in;

import com.icubexs.SalesSystem.domain.model.Item;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item save(Item item);
    Optional<Item> findById(Long id);
    Optional<Item> findBySerialNumber(String serialNumber);
    List<Item> findByProductId(Long productId);
    List<Item> findByBatchId(Long batchId);
    void deleteById(Long id);
}