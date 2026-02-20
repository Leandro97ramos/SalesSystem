package com.icubexs.SalesSystem.infraestructure.jpa.adapter.out.persistence;

import com.icubexs.SalesSystem.domain.model.Item;
import com.icubexs.SalesSystem.domain.model.repository.ItemRepository;
import com.icubexs.SalesSystem.infraestructure.jpa.repository.ItemJpaRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemPersistenceAdapter implements ItemRepository {

    private final ItemJpaRepository jpaItemRepository;

    @Override
    public Item save(Item item) {
        // Aquí conviertes Item (Dominio) a ItemEntity (JPA) y guardas
        return null; // Implementar mapeo
    }
}