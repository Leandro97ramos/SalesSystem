package com.icubexs.SalesSystem.application.service;

import com.icubexs.SalesSystem.domain.model.Item;
import com.icubexs.SalesSystem.domain.model.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item registrarItem(Item item) {
        // Aquí meterás la lógica de validación de negocio más adelante
        return itemRepository.save(item);
    }
}