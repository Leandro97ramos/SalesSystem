package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.domain.model.Item;
import com.icubexs.SalesSystem.application.port.out.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item registerItem(Item item) {
        // En el futuro: Validar que el skuCode no esté duplicado
        return itemRepository.save(item);
    }
}