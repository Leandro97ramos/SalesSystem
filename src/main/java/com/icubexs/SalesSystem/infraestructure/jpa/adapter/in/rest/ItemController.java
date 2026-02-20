package com.icubexs.SalesSystem.infraestructure.jpa.adapter.in.rest;

import com.icubexs.SalesSystem.application.service.ItemService;
import com.icubexs.SalesSystem.domain.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService; // Llama al puerto de entrada

    @PostMapping
    public Item crearItem(@RequestBody Item item) {
        return itemService.registrarItem(item); // [cite: 172]
    }
}