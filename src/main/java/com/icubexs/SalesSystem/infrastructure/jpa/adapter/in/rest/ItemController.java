package com.icubexs.SalesSystem.infrastructure.jpa.adapter.in.rest;

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
    public Item createItem(@RequestBody Item item) {
        return itemService.registerItem(item); // Llama al servicio de aplicación
    }
}