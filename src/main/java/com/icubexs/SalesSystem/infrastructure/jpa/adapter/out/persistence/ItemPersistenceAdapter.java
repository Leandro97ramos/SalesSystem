package com.icubexs.SalesSystem.infrastructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.domain.model.Item;
import com.icubexs.SalesSystem.application.port.out.ItemRepository;
import com.icubexs.SalesSystem.infrastructure.jpa.entity.ItemEntity;
import com.icubexs.SalesSystem.infrastructure.jpa.repository.ItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ItemPersistenceAdapter implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public Item save(Item item) {
        ItemEntity entity = new ItemEntity();
        entity.setSkuCode(item.getSkuCode()); // [cite: 176]
        entity.setName(item.getName()); // [cite: 177]
        entity.setDescription(item.getDescription()); // [cite: 177]
        entity.setUnitMeasure(item.getUnitMeasure()); // [cite: 178]
        entity.setLength(item.getLength()); //
        entity.setWidth(item.getWidth()); //
        entity.setHeight(item.getHeight()); //
        entity.setWeight(item.getWeight()); //

        ItemEntity saved = itemJpaRepository.save(entity);
        return mapToDomain(saved);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemJpaRepository.findById(id).map(this::mapToDomain);
    }


    @Override
    public Optional<Item> findBySku(String sku) {
        return Optional.empty();
    }



    private Item mapToDomain(ItemEntity entity) {
        return new Item(
                entity.getItemId(), entity.getSkuCode(), entity.getName(),
                entity.getDescription(), entity.getUnitMeasure(), entity.getLength(),
                entity.getWidth(), entity.getHeight(), entity.getWeight()
        );
    }
}