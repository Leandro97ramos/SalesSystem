package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private Long inventoryId;
    private Long batchId;
    private Long configDetailId; // Referencia al Bin/Cajón final
    private Integer currentQuantity;
}