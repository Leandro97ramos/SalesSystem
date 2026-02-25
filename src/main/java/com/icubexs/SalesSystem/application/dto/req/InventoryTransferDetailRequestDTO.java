package com.icubexs.SalesSystem.application.dto.req;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class InventoryTransferDetailRequestDTO {
    private Long inventoryTransferId;
    private Long batchId;
    private BigDecimal quantity;
}