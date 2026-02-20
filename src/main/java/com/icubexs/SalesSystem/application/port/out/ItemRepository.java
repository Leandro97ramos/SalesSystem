package com.icubexs.SalesSystem.application.port.out;

import com.icubexs.SalesSystem.domain.model.Item;
import java.util.Optional;

public interface ItemRepository {
    Item save(Item item);
    Optional<Item> findById(Long id);
    Optional<Item> findBySku(String sku);
}