package com.icubexs.SalesSystem.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryTransferDetail {
    private Long id;
    private InventoryTransfer inventoryTransfer; // inventory_transfer_id
    private Batch batch;                         // batch_id
    private BigDecimal quantity;                 // quantity
}