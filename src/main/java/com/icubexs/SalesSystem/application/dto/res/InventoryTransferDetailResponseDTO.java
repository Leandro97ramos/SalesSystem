package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class InventoryTransferDetailResponseDTO {
    private Long id;
    private Long inventoryTransferId;
    private String batchCode;
    private String productName;
    private BigDecimal quantity;
}