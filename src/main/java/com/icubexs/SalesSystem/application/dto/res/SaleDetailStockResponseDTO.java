package com.icubexs.SalesSystem.application.dto.res;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SaleDetailStockResponseDTO {
    private Long id;
    private Long saleDetailId;
    private Long stockId;
    private String serialNumber; // Si aplica
    private BigDecimal quantity;
}

